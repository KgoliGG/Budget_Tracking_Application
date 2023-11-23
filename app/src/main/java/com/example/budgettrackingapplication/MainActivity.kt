@file:Suppress("DEPRECATION")

package com.example.budgettrackingapplication

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.budgettrackingapplication.composable.pages.AddScreen
import com.example.budgettrackingapplication.composable.pages.CategoriesScreen
import com.example.budgettrackingapplication.composable.pages.ExpensesScreen
import com.example.budgettrackingapplication.composable.pages.LandingPage
import com.example.budgettrackingapplication.composable.pages.LoginPage
import com.example.budgettrackingapplication.composable.pages.PrivacyPoliciesScreen
import com.example.budgettrackingapplication.composable.pages.RegistrationPage
import com.example.budgettrackingapplication.composable.pages.ReportsScreen
import com.example.budgettrackingapplication.composable.pages.SettingsScreen
import com.example.budgettrackingapplication.composable.pages.TermsAndConditionScreen
import com.example.budgettrackingapplication.composable.pages.UserSetup
import com.example.budgettrackingapplication.composable.ui.theme.TopAppBarBackground
import com.example.budgettrackingapplication.navigation.Screen
import com.example.budgettrackingapplication.ui.theme.BudgetTrackingApplicationTheme
import io.sentry.compose.withSentryObservableEffect

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
//        SentryAndroid.init(this) { options ->
//            options.dsn = "https://examplePublicKey@o0.ingest.sentry.io/0"
//            // Add a callback that will be used before the event is sent to Sentry.
//            // With this callback, you can modify the event or, when returning null, also discard the event.
//            options.beforeSend =
//                BeforeSendCallback { event: SentryEvent, hint: Hint ->
//                    if (SentryLevel.DEBUG == event.level) {
//                        null
//                    } else {
//                        event
//                    }
//                }
//        }
        setContent {
            BudgetTrackingApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var showBottomBar by rememberSaveable { mutableStateOf(true) }
                    val navController = rememberNavController().withSentryObservableEffect()
                    val backStackEntry by navController.currentBackStackEntryAsState()

                    showBottomBar = when (backStackEntry?.destination?.route) {
                        Screen.SettingsCategoriesScreen.name,
                        Screen.LandingPage.name,
                        Screen.LoginPage.name,
                        Screen.RegistrationPage.name,
                        Screen.PrivacyPolicies.name,
                        Screen.TermsAndCondition.name,
                        Screen.UserSetup.name
                        -> false
                        else -> true
                    }

                    Scaffold(
                        bottomBar = {
                            if (showBottomBar) {
                                NavigationBar(containerColor = TopAppBarBackground) {
                                    NavigationBarItem(
                                        selected = backStackEntry?.destination?.route == Screen.ExpensesScreen.name,
                                        onClick = { navController.navigate(Screen.ExpensesScreen.name) },
                                        label = {
                                            Text("Expenses")
                                        },
                                        icon = {
                                            Icon(
                                                painterResource(id = R.drawable.upload),
                                                contentDescription = "Upload"
                                            )
                                        }
                                    )
                                    NavigationBarItem(
                                        selected = backStackEntry?.destination?.route == Screen.ReportsScreen.name,
                                        onClick = { navController.navigate(Screen.ReportsScreen.name) },
                                        label = {
                                            Text("Reports")
                                        },
                                        icon = {
                                            Icon(
                                                painterResource(id = R.drawable.bar_chart),
                                                contentDescription = "Reports"
                                            )
                                        }
                                    )
                                    NavigationBarItem(
                                        selected = backStackEntry?.destination?.route == Screen.AddScreen.name,
                                        onClick = { navController.navigate(Screen.AddScreen.name) },
                                        label = {
                                            Text("Add")
                                        },
                                        icon = {
                                            Icon(
                                                painterResource(id = R.drawable.add),
                                                contentDescription = "Add"
                                            )
                                        }
                                    )
                                    NavigationBarItem(
                                        selected = backStackEntry?.destination?.route?.startsWith(Screen.SettingsScreen.name)
                                            ?: false,
                                        onClick = { navController.navigate(Screen.SettingsScreen.name) },
                                        label = {
                                            Text("Settings")
                                        },
                                        icon = {
                                            Icon(
                                                painterResource(id = R.drawable.settings_outlined),
                                                contentDescription = "Settings"
                                            )
                                        }
                                    )
                                }
                            }
                        },
                        content = { innerPadding ->
                            NavHost(
                                navController = navController,
                                startDestination = Screen.ExpensesScreen.name
                            ) {
                                composable(route = Screen.RegistrationPage.name) {
                                    Surface(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(innerPadding),
                                    ) {
                                        RegistrationPage(navController = navController)
                                    }                                }
                                composable(route = Screen.LandingPage.name) {
                                    Surface(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(innerPadding),
                                    ) {
                                        LandingPage(navController = navController)
                                    }                                }
                                composable(route = Screen.LoginPage.name) {
                                    Surface(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(innerPadding),
                                    ) {
                                        LoginPage(navController = navController)
                                    }                                }
                                composable(route = Screen.UserSetup.name) {
                                    Surface(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(innerPadding),
                                    ) {
                                        UserSetup(navController = navController)
                                    }                                }
                                composable(route = Screen.ExpensesScreen.name) {
                                    Surface(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(innerPadding),
                                        ) {
                                        ExpensesScreen(navController = navController)
                                    }
                                }
                                composable(route = Screen.TermsAndCondition.name){
                                    Surface(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(innerPadding),
                                    ) {
                                        TermsAndConditionScreen(navController = navController)
                                    }                                }
                                composable(route = Screen.PrivacyPolicies.name){
                                    Surface(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(innerPadding),
                                    ) {
                                        PrivacyPoliciesScreen(navController = navController)
                                    }                                }
                                composable(route = Screen.ReportsScreen.name) {
                                    Surface(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(innerPadding),
                                        ) {
                                        ReportsScreen()
                                    }
                                }
                                composable(route = Screen.AddScreen.name) {
                                    Surface(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(innerPadding),
                                        ) {
                                        AddScreen(navController = navController)
                                    }
                                }
                                composable(route = Screen.SettingsScreen.name) {
                                    Surface(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(innerPadding),
                                        ) {
                                        SettingsScreen(navController = navController)
                                    }
                                }
                                composable(route = Screen.SettingsCategoriesScreen.name) {
                                    Surface(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(innerPadding),
                                        ) {
                                        CategoriesScreen(navController = navController)
                                    }
                                }
                            }
                        }
                    )}
            }
        }
    }
}

