package li.by.amazinggifs.model

import androidx.lifecycle.MediatorLiveData
import li.by.amazinggifs.model.database.AppDatabase
import li.by.amazinggifs.model.database.GifDatabaseModel
import li.by.amazinggifs.utils.applicationContext


object GifsDataBaseRepository {

    fun insert(gif: GifDatabaseModel) {
        AppDatabase.getInstance(applicationContext)?.gifDao()?.insert(gif)
    }

    fun delete(gif: GifDatabaseModel) {
        AppDatabase.getInstance(applicationContext)?.gifDao()?.delete(gif)
    }

    private var mediatorLiveData = MediatorLiveData<List<GifDatabaseModel>>()

    fun getAllGifs(): List<GifDatabaseModel> {
        return AppDatabase.getInstance(applicationContext)?.gifDao()?.getAllGifs()!!
    }


}
