package li.by.amazinggifs.model.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "gif")
class GifDatabaseModel(
        @PrimaryKey val id: Int,
        val title: String,
        val pathURL: String
)