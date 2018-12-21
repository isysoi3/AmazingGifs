package li.by.amazinggifs.model.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
public interface GifDao {

    @Insert
    fun insert(gif: GifDatabaseModel)

    @Delete
    fun delete(gif: GifDatabaseModel)

    @Query("SELECT * FROM gif")
    fun getAllGifs(): List<GifDatabaseModel>

}