package ca.georgiancollege.ice7

import androidx.room.*

@Dao
interface TVShowDao
{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(tvShow: TVShow)
    @Update
    suspend fun update(tvShow: TVShow)
    @Delete
    suspend fun delete(tvShow: TVShow)
    @Query("SELECT * FROM tv_shows")
    suspend fun getAllTVShows(): List<TVShow>
    @Query("SELECT * FROM tv_shows WHERE id = :id")
    suspend fun getTVShowById(id: Int): TVShow?

}