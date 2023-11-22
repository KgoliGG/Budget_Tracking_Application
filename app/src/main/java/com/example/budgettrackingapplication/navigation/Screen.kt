package com.example.budgettrackingapplication.navigation

//sealed class Screen (val route : String) {
//    object Landing : Screen(route = "landing_screen")
//    object Registration : Screen(route = "registration_screen")
//    object Login : Screen(route = "login_screen")
//}

enum class  Screen{
    LandingPage,
    RegistrationPage,
    LoginPage,
    UserSetup,
    TermsAndCondition,
    PrivacyPolicies,
    HomeScreen
}
