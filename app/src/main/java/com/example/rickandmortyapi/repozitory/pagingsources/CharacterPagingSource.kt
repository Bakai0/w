package com.example.rickandmortyapi.repozitory.pagingsources

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rickandmortyapi.data.network.apiservise.CharacterApiService
import com.example.rickandmortyapi.model.CharacterModel
import retrofit2.HttpException
import java.io.IOException

private const val  CHARACTER_STARTING_PAGE_INDEX = 1

class CharacterPagingSource(private val characterApiService: CharacterApiService)
    : PagingSource<Int , CharacterModel>() {
    override fun getRefreshKey(state: PagingState<Int, CharacterModel>): Int? {
    return  state.anchorPosition?.let { anchorPosition ->
        val anchorPage = state.closestPageToPosition(anchorPosition)
        anchorPage?.prevKey?.plus(1)?: anchorPage?.nextKey?.minus(1)
    }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterModel> {
        val position = params.key ?: CHARACTER_STARTING_PAGE_INDEX
        return try {
            val responce = characterApiService.fetchCHaracters(position)
            val next = responce.info.next
            val nextPageNumber = if (next == null) {
                null
            } else
                Uri.parse(responce.info.next).getQueryParameter("page")!!.toInt()
            LoadResult.Page(
                data = responce.result,
                prevKey = null,
                nextKey = nextPageNumber
            )
        } catch (exception: IOException){
            return LoadResult.Error(exception)
        } catch (exception: HttpException){
            return LoadResult.Error(exception )
        }
    }
}