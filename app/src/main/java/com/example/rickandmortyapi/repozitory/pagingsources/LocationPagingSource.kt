package com.example.rickandmortyapi.repozitory.pagingsources

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rickandmortyapi.data.network.apiservise.LocationApiService
import com.example.rickandmortyapi.model.LocationModel
import retrofit2.HttpException
import java.io.IOException

private const val LOCATION_STARTING_PAGE_INDEX = 1

class LocationPagingSources(private val locationApiService: LocationApiService) :
    PagingSource<Int, LocationModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, LocationModel> {
        val position = params.key ?: LOCATION_STARTING_PAGE_INDEX
        return try {
            val response = locationApiService.fetchLocation(position)
            val next  = response.info.next
            val nextPageNumber = if (next == null){
                null
            }else
                Uri.parse(response.info.next).getQueryParameter("page")!!.toInt()
            LoadResult.Page(
                response.result,null , nextPageNumber
            )
        }catch (exception : IOException){
            return LoadResult.Error(exception)
        }catch (exception : HttpException){
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, LocationModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPosition = state.closestPageToPosition(anchorPosition)
            anchorPosition?.prevKey?.plus(1) ?: anchorPosition?.nextKey?.minus(1)
        }
    }
}