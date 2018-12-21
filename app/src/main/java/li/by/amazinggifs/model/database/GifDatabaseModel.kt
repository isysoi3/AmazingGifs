package li.by.amazinggifs.model.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "gif")
class GifDatabaseModel(
        val title: String = "",
        val pathURL: String = ""
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}