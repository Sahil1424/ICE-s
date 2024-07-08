package ca.georgiancollege.ice7

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TVShow::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase()
{
    abstract fun tvShowDao(): TVShowDao

    companion object
    {
        @Volatile
        private var m_instance: AppDatabase? = null
       fun getDatabase(context: Context): AppDatabase
        {
            return m_instance ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "media_database"
                ).build()
                m_instance = instance
                return instance
            }
        }
    }
}