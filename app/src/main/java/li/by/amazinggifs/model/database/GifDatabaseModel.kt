package li.by.amazinggifs.model.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "gif")
class GifDatabaseModel(
    @PrimaryKey var pathURL: String = "",
    var title: String = "",
    var height: Int = 0
)