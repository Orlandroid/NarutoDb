package com.example.data.tailedbeasts

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.domain.tailedbeasts.TailedBeast
import retrofit2.HttpException


class TailedBeastsPagingSource(
    private val service: TailedBeastsApi
) : PagingSource<Int, TailedBeast>() {

    companion object {
        private const val START_PAGE = 1
    }

    override suspend fun load(
        params: LoadParams<Int>
    ): LoadResult<Int, TailedBeast> {
        return try {
            val currentPage = params.key ?: START_PAGE
            val data = service.getAllTailedBeasts(page = currentPage.toString())
            LoadResult.Page(
                data = data.tailedBeasts,
                prevKey = if (currentPage == START_PAGE) null else currentPage - 1,
                nextKey = if (data.tailedBeasts.isEmpty()) null else currentPage.plus(1)
            )
        } catch (e: Exception) {
            println(e.message)
            if (e is HttpException) {
                val errorString =
                    e.response()?.errorBody()?.byteStream()?.bufferedReader().use { it?.readText() }
                LoadResult.Error(Throwable(errorString))
            } else {
                LoadResult.Error(e)
            }
        }
    }

    override fun getRefreshKey(state: PagingState<Int, TailedBeast>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}