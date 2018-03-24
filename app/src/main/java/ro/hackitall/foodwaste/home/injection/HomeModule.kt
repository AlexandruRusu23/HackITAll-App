package ro.hackitall.foodwaste.home.injection

import dagger.Module
import dagger.Provides
import ro.hackitall.foodwaste.home.mvp.HomeContract
import ro.hackitall.foodwaste.home.mvp.HomePresenter

/**
 * Created by Emilian on 3/24/2018.
 *
 */
@Module
class HomeModule (val homeView : HomeContract.HomeView) {

    @Provides
    fun provideView() : HomeContract.HomeView = homeView

    @Provides
    fun providePresenter(homePresenter: HomePresenter) : HomeContract.HomePresenter = homePresenter

}