package li.by.amazinggifs.model.database

import android.content.Context
import androidx.room.RoomDatabase
import androidx.room.Database
import androidx.room.Room
import okhttp3.internal.Internal.instance


@Database(entities = arrayOf(GifDatabaseModel::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun gifDao(): GifDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        private val DATABASE_NAME = "GifDb.db"

        fun getInstance(context: Context): AppDatabase? {
            if (instance == null) {
                synchronized(AppDatabase::class.java) {
                    instance = Room.databaseBuilder(context,
                            AppDatabase::class.java,
                            DATABASE_NAME)
                            .allowMainThreadQueries()
                            .build()
                }
            }
            return instance
        }
    }


}