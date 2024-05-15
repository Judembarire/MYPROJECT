package net.ezra.navigation

import LoginScreen
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import net.ezra.ui.add.AddProductScreen
import net.ezra.ui.auth.SignUpScreen
import net.ezra.ui.community.CommScreen
import net.ezra.ui.guide.GuideScreen
import net.ezra.ui.guide.GuideScreen2
import net.ezra.ui.guide.GuideScreen3
import net.ezra.ui.guide.GuideScreen4
import net.ezra.ui.guide.GuideScreen5
import net.ezra.ui.guide.GuideScreen6
import net.ezra.ui.home.HomeScreen
import net.ezra.ui.myplant.PlantScreen
import net.ezra.ui.splash.SplashScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_REGISTER


) {
    BackHandler {
        navController.popBackStack()

        }
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {


        composable(ROUTE_HOME) {
            HomeScreen(navController)
        }

        composable(ROUTE_SPLASH) {
            SplashScreen(navController)
        }

        composable(ROUTE_LOGIN) {
            LoginScreen(navController){}
        }

        composable(ROUTE_REGISTER) {
            SignUpScreen(navController){}
        }

        composable(ROUTE_PLANT) {
            PlantScreen(navController)
        }

        composable(ROUTE_GUIDE) {
            GuideScreen(navController)
        }

        composable(ROUTE_GUIDE2) {
            GuideScreen2(navController)
        }

        composable(ROUTE_GUIDE3) {
            GuideScreen3(navController)
        }

        composable(ROUTE_GUIDE4) {
            GuideScreen4(navController)
        }

        composable(ROUTE_GUIDE5) {
            GuideScreen5(navController)
        }

        composable(ROUTE_GUIDE6) {
            GuideScreen6(navController)
        }



        composable(ROUTE_ADD) {
            AddProductScreen(navController)
        }

        composable(ROUTE_COMM) {
            CommScreen(navController)
        }











    }
}