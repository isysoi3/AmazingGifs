package li.by.amazinggifs

import android.app.Application


class GifsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        application = this
    }

    companion object {
        lateinit var application: GifsApplication
    }
}
