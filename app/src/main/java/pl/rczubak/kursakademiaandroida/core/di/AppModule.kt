package pl.rczubak.kursakademiaandroida.core.di

import android.content.Context
import android.net.ConnectivityManager
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import pl.rczubak.kursakademiaandroida.core.network.NetworkStateProvider
import pl.rczubak.kursakademiaandroida.core.network.NetworkStateProviderImpl

val appModule = module {
    factory { LinearLayoutManager(androidContext()) }

    factory { GridLayoutManager(androidContext(), 2) }

    factory { DividerItemDecoration(androidContext(), LinearLayoutManager.VERTICAL) }

    factory { androidContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager }

    factory<NetworkStateProvider> { NetworkStateProviderImpl(get()) }
}