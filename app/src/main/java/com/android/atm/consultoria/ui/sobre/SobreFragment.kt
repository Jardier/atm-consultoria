package com.android.atm.consultoria.ui.sobre


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.android.atm.consultoria.R
import mehdi.sakout.aboutpage.AboutPage
import mehdi.sakout.aboutpage.Element

/**
 * A simple [Fragment] subclass.
 */
class SobreFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val descricao : String = "A ATM Consultoria tem a missão de apoior Organizações " +
                "que desejam alcançar o sucesso atráves da excelência em Gestão e " +
                "da busca pela qualidade.";
        val versao : Element = Element();
        versao.setTitle("Versão 1.0");

        return AboutPage(activity)
                .setImage(R.drawable.logo)
                .setDescription(descricao)
                .addGroup("Entre em Contato")
                .addEmail("atendimento@atmconsultoria.com.br","Envie um e-mail")
                .addWebsite("https://google.com", "Acesse nosso site")
                .addWebsite("https://www.google.com/maps/place/Rua+Herm%C3%ADnio+Barroso,+4360+-+S%C3%A3o+Jo%C3%A3o+do+Tauape,+Fortaleza+-+CE,+60851-640/@-3.7605981,-38.5105803,3a,75y,246.75h,90t/data=!3m7!1e1!3m5!1sFMb_P7_OmrREpjXR0IiAAQ!2e0!6s%2F%2Fgeo2.ggpht.com%2Fcbk%3Fpanoid%3DFMb_P7_OmrREpjXR0IiAAQ%26output%3Dthumbnail%26cb_client%3Dmaps_sv.tactile.gps%26thumb%3D2%26w%3D203%26h%3D100%26yaw%3D246.74509%26pitch%3D0%26thumbfov%3D100!7i13312!8i6656!4m7!3m6!1s0x7c748c8c84883ff:0x3185e216a1947168!8m2!3d-3.7606444!4d-38.5107562!14m1!1BCgIgARICCAI",
                    "Nosso endereço")
                .addGroup("Redes Sociais")
                .addFacebook("jardier", "Facebook")
                .addInstagram("jardier","Instagram")
                .addTwitter("jardier","Twitter")
                .addYoutube("jardier","Youtube")
                .addGitHub("jardier","GitHub")
                .addPlayStore("com.bradesco", "Download App")
                .addItem(versao)
                .create();
        //return inflater.inflate(R.layout.fragment_sobre, container, false)

    }


}
