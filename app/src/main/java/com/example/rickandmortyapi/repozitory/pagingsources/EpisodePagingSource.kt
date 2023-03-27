package com.example.rickandmortyapi.repozitory.pagingsources

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rickandmortyapi.data.network.apiservise.EpisodApiService
import com.example.rickandmortyapi.model.EpisodeModel
import retrofit2.HttpException
import java.io.IOException

private const val EPISODE_STARTING_PAGE_INDEX = 1

class EpisodePagingSources(private val episodeApiService: EpisodApiService) :
    PagingSource<Int, EpisodeModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, EpisodeModel> {
        val position = params.key ?: EPISODE_STARTING_PAGE_INDEX
        return try {
            val response = episodeApiService.fetchEpisodes(position)
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

    override fun getRefreshKey(state: PagingState<Int, EpisodeModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPosition = state.closestPageToPosition(anchorPosition)
            anchorPosition?.prevKey?.plus(1) ?: anchorPosition?.nextKey?.minus(1)
        }
    }
}