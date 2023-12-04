package com.dinadurykina.mediagid

import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.dinadurykina.mediagid.databinding.ActivityGuideBinding
import com.dinadurykina.mediagid.ui.Play
import com.dinadurykina.mediagid.ui.ViewModelGuide
import com.google.android.material.navigation.NavigationView
import com.google.mlkit.common.MlKitException
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.codescanner.GmsBarcodeScannerOptions
import com.google.mlkit.vision.codescanner.GmsBarcodeScanning
import java.util.Locale


class MediaGuide : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityGuideBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGuideBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        val navHostFragment = (supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main) as NavHostFragment)
        val inflater = navHostFragment.navController.navInflater
        val graph = inflater.inflate(R.navigation.mobile_navigation)

//graph.addArgument("argument", NavArgument)
//        graph.setStartDestination(R.id.fragment1)
//or

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        // Передача идентификатора каждого меню в виде набора идентификаторов,
        // поскольку каждое меню следует рассматривать как пункты назначения верхнего уровня.

        val viewModelGuide =
            ViewModelProvider(this).get(ViewModelGuide::class.java)

        val navFragmentsID = setOf(R.id.nav_p_1, R.id.nav_p_2, R.id.nav_p_3, R.id.nav_p_4)
        //val fragmentsNames: List<String> = navFragmentsID.forEach { this.resources.getResourceEntryName(it).toString() }
        val fragmentsNames: Set<String> = setOf("nav_p_1", "nav_p_2", "nav_p_3", "nav_p_4")
        appBarConfiguration = AppBarConfiguration(navFragmentsID, drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        Play.init(this)

        val startFragment = intent.extras?.getString("FragmentName")
        if (startFragment != null) {
            if (startFragment.startsWith("com.dinadurykina.mediagid")) {
                val navIndex = fragmentsNames.indexOf(startFragment.split(".").last())
                val navP = navFragmentsID.toList()[navIndex]
                viewModelGuide.navNew(fragmentsNames.toList()[navIndex])
                // Не используется - с параметрами откроет слушатель
                //graph.setStartDestination(navP)
                //navHostFragment.navController.graph = graph
            }
        } else {
            // вход в mediaGuide без параметров - по умолчанию
            navHostFragment.navController.graph = graph
        }

        binding.appBarMain.fab.setOnClickListener { view ->

            val options = GmsBarcodeScannerOptions.Builder()
                // чтобы обнаружить только  QR-коды
                .setBarcodeFormats(
                    Barcode.FORMAT_QR_CODE)
                // чтобы обнаружить только ацтекский код
                //  Barcode.FORMAT_AZTEC
               //Чтобы включить функцию автоматического масштабирования
                .enableAutoZoom() // available on 16.1.0 and higher
                .build()

            // Получите экземпляр GmsBarcodeScanner
            //val scanner = GmsBarcodeScanning.getClient(this)
            // Or with a configured options
            val scanner = GmsBarcodeScanning.getClient(this, options)

            var taskCompleted ="NONE"
            // Запросите сканирование кода
            scanner.startScan()
                .addOnSuccessListener { barcode ->
                    val barcodeAll = barcode.rawValue
                    taskCompleted = "Task completed successfully ${barcode.rawValue}"

                    if (barcodeAll != null) {
                        if (barcodeAll.startsWith("com.dinadurykina.mediagid")) {
                           viewModelGuide.navNew( barcodeAll.split(".").last() )
                        }
                    }
                }
                .addOnCanceledListener {
                    taskCompleted = "Task canceled "
                    Toast.makeText(this,getString(R.string.error_scanner_cancelled), Toast.LENGTH_LONG).show()
                }
                .addOnFailureListener { e: Exception -> taskCompleted = "Task failed with an exception \n $e"
                    Toast.makeText(this,getErrorMessage(e), Toast.LENGTH_LONG).show()
                }

          //  Snackbar.make(view, "Scan $ name  -->$startFragment<-- $nomberFragment  $taskCompleted" , Snackbar.LENGTH_LONG)
          //      .setAction("Action", null).show()
        }

        viewModelGuide.navPageTo.observe(this) {
            val navIndex = fragmentsNames.indexOf(it)
            var navP: Int = -1
            if (navIndex >= 0) {
                navP = navFragmentsID.toList()[navIndex]
                val name = this.resources.getResourceEntryName(navP)

//                val navHostFragment = (this.supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main) as NavHostFragment)
//                val inflater = navHostFragment.navController.navInflater
                val graph = inflater.inflate(R.navigation.mobile_navigation)

                //graph.addArgument("argument", NavArgument)
                //or
                //graph.setStartDestination(R.id.fragment2)

                        graph.setStartDestination(navP)
                        navHostFragment.navController.graph = graph

                //navController.navigate(navP)

            } else Toast.makeText(this, "${it}неизвестная страница ", Toast.LENGTH_LONG).show()

            Toast.makeText(
                this,
                "${viewModelGuide.navPageTo.value} $navIndex $navP ",
                Toast.LENGTH_LONG
            ).show()
        }


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present. Settings
        // Расширьте меню; это добавит элементы на панель действий, если она присутствует.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onStop() {
        super.onStop()
        Play.stop()
    }

    private fun getSuccessfulMessage(barcode: Barcode): String {
        val barcodeValue =
            String.format(
                Locale.US,
                "Display Value: %s\nRaw Value: %s\nFormat: %s\nValue Type: %s",
                barcode.displayValue,
                barcode.rawValue,
                barcode.format,
                barcode.valueType
            )
        return getString(R.string.barcode_result, barcodeValue)
 //       return  barcodeValue
    }
    private fun getErrorMessage(e: Exception): String? {
        return if (e is MlKitException) {
            when (e.errorCode) {
                MlKitException.CODE_SCANNER_CAMERA_PERMISSION_NOT_GRANTED ->
                    getString(R.string.error_camera_permission_not_granted)
                MlKitException.CODE_SCANNER_APP_NAME_UNAVAILABLE ->
                    getString(R.string.error_app_name_unavailable)
                else -> getString(R.string.error_default_message, e)
            }
        } else {
            e.message
        }
    }
}