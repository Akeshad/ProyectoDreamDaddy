package com.example.dreamdaddy.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.dreamdaddy.R
import com.example.dreamdaddy.classes.SugarBaby
import com.example.dreamdaddy.classes.kindBaby


class RoleSugarBabyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_sugar_baby_role)
    }

    fun createNewBabyOtter(view: View) {
        val sugarBaby = SugarBaby()
        sugarBaby.kind = kindBaby.OTTER
        sugarBaby.linkImage = R.drawable.llamar

        val intent = Intent(this, RegisterActivity::class.java)
        intent.putExtra("sugarbaby", sugarBaby)
        startActivity(intent)
    }
    fun createNewBabySpoiled(view: View) {
        val sugarBaby = SugarBaby()
        sugarBaby.kind = kindBaby.SPOILED
        // TODO IMAGEN DEL BADDY. PROCESAR Y LINKEAR EN ESTA LINEA

        val intent = Intent(this, RegisterActivity::class.java)
        intent.putExtra("sugarbaby", sugarBaby)
        startActivity(intent)
    }
    fun createNewBabyFancy(view: View) {
        val sugarBaby = SugarBaby()
        sugarBaby.kind = kindBaby.FANCY
        // TODO IMAGEN DEL BADDY. PROCESAR Y LINKEAR EN ESTA LINEA

        val intent = Intent(this, RegisterActivity::class.java)
        intent.putExtra("sugarbaby", sugarBaby)
        startActivity(intent)
    }
    fun createNewBabyCup(view: View) {
        val sugarBaby = SugarBaby()
        sugarBaby.kind = kindBaby.CUP
        // TODO IMAGEN DEL BADDY. PROCESAR Y LINKEAR EN ESTA LINEA

        val intent = Intent(this, RegisterActivity::class.java)
        intent.putExtra("sugarbaby", sugarBaby)
        startActivity(intent)
    }
    fun createNewBabyChub(view: View) {
        val sugarBaby = SugarBaby()
        sugarBaby.kind = kindBaby.CHUB
        // TODO IMAGEN DEL BADDY. PROCESAR Y LINKEAR EN ESTA LINEA

        val intent = Intent(this, RegisterActivity::class.java)
        intent.putExtra("sugarbaby", sugarBaby)
        startActivity(intent)
    }
    fun createNewBabyRomantic(view: View) {
        val sugarBaby = SugarBaby()
        sugarBaby.kind = kindBaby.ROMANTIC
        // TODO IMAGEN DEL BADDY. PROCESAR Y LINKEAR EN ESTA LINEA

        val intent = Intent(this, RegisterActivity::class.java)
        intent.putExtra("sugarbaby", sugarBaby)
        startActivity(intent)
    }
    fun createNewBabyEmo(view: View) {
        val sugarBaby = SugarBaby()
        sugarBaby.kind = kindBaby.EMO
        // TODO IMAGEN DEL BADDY. PROCESAR Y LINKEAR EN ESTA LINEA

        val intent = Intent(this, RegisterActivity::class.java)
        intent.putExtra("sugarbaby", sugarBaby)
        startActivity(intent)
    }
    fun createNewBabyOther(view: View) {
        val sugarBaby = SugarBaby()
        sugarBaby.kind = kindBaby.OTTER
        // TODO IMAGEN DEL BADDY. PROCESAR Y LINKEAR EN ESTA LINEA

        val intent = Intent(this, RegisterActivity::class.java)
        intent.putExtra("sugarbaby", sugarBaby)
        startActivity(intent)
    }
}