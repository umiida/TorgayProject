package uz.texnopos.torgayproject.ui.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.texnopos.torgayproject.ui.data.dao.NationalBaseDao
import uz.texnopos.torgayproject.ui.data.model.Muzeyler
import uz.texnopos.torgayproject.ui.data.model.Tabiyat

@Database(entities = [Muzeyler::class, Tabiyat::class], version = 1)
abstract class TorgayDataBase: RoomDatabase() {

    companion object{
        lateinit var INSTANCE : TorgayDataBase
        fun getInstance(context: Context) : TorgayDataBase{
            if(!::INSTANCE.isInitialized){
                INSTANCE = Room.databaseBuilder(
                    context, TorgayDataBase::class.java,
                    "Book.db"
                )
                    .createFromAsset("Book.db")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }
    }
    abstract fun dao(): NationalBaseDao
}