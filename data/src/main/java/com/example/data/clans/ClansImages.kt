package com.example.data.clans

import com.example.domain.clans.ClansResponseV2
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


fun getClansApiImages(): String {
    return """[
        {
        "link": "https://naruto.fandom.com/pt-br/wiki/Cl%C3%A3_Aburame",
        "icon": "http://pm1.narvii.com/6401/9166125f4fa0ba70244cadbfba51ace7ecba57d3_00.jpg",
        "name": "Cla Aburame",
        "id": 1
    },
    {
        "link": "https://naruto.fandom.com/pt-br/wiki/Cl%C3%A3_Akimichi",
        "icon": "https://static.wikia.nocookie.net/naruto/images/5/53/S%C3%ADmbolo_Cl%C3%A3_Akimichi.svg/revision/latest/scale-to-width-down/70?cb=20121117153814&path-prefix=pt-br",
        "name": "Cla Akimichi",
        "id": 2
    },
    {
        "link": "https://naruto.fandom.com/pt-br/wiki/Cl%C3%A3_Amagiri",
        "icon": "https://static.wikia.nocookie.net/naruto/images/3/3e/S%C3%ADmbolo_Amagiri.svg/revision/latest/scale-to-width-down/70?cb=20150510021927&path-prefix=pt-br",
        "name": "Cla Amagiri",
        "id": 3
    },
    {
        "link": "https://naruto.fandom.com/pt-br/wiki/Cl%C3%A3_F%C5%ABma",
        "icon": "https://static.wikia.nocookie.net/naruto/images/e/e3/S%C3%ADmbolo_Cl%C3%A3_Fuma.svg/revision/latest/scale-to-width-down/70?cb=20121117155945&path-prefix=pt-br",
        "name": "Cla Fuma",
        "id": 4
    },
    {
        "link": "https://naruto.fandom.com/pt-br/wiki/Cl%C3%A3_F%C5%ABma_(Pa%C3%ADs_do_Som)",
        "icon": "https://static.wikia.nocookie.net/naruto/images/e/e3/S%C3%ADmbolo_Cl%C3%A3_Fuma.svg/revision/latest/scale-to-width-down/70?cb=20121117155945&path-prefix=pt-br",
        "name": "Cla Fuma (Pais do Som)",
        "id": 5
    },
    {
        "link": "https://naruto.fandom.com/pt-br/wiki/Cl%C3%A3_Hagoromo",
        "icon": "https://static.wikia.nocookie.net/naruto/images/8/8a/S%C3%ADmbolo_Cl%C3%A3_Desconhecido_6.svg/revision/latest/scale-to-width-down/70?cb=20121117160411&path-prefix=pt-br",
        "name": "Cla Hagoromo",
        "id": 6
    },
    {
        "link": "https://naruto.fandom.com/pt-br/wiki/Cl%C3%A3_Hirasaka",
        "icon": "",
        "name": "Cla Hirasaka",
        "id": 7
    },
    {
        "link": "https://naruto.fandom.com/pt-br/wiki/Cl%C3%A3_H%C5%8Dzuki",
        "icon": "https://static.wikia.nocookie.net/naruto/images/2/24/S%C3%ADmbolo_Cl%C3%A3_Hozuki.svg/revision/latest/scale-to-width-down/70?cb=20121117155848&path-prefix=pt-br",
        "name": "Cla Hozuki",
        "id": 8
    },
    {
        "link": "https://naruto.fandom.com/pt-br/wiki/Cl%C3%A3_Hy%C5%ABga",
        "icon": "https://static.wikia.nocookie.net/naruto/images/2/20/S%C3%ADmbolo_Cl%C3%A3_Hyuga.svg/revision/latest/scale-to-width-down/70?cb=20210527020510&path-prefix=pt-br",
        "name": "Cla Hyuga",
        "id": 9
    },
    {
        "link": "https://naruto.fandom.com/pt-br/wiki/Cl%C3%A3_Inuzuka",
        "icon": "https://static.wikia.nocookie.net/naruto/images/1/12/S%C3%ADmbolo_Cl%C3%A3_Inuzuka.svg/revision/latest/scale-to-width-down/70?cb=20150515014016&path-prefix=pt-br",
        "name": "Cla Inuzuka",
        "id": 10
    },
    {
        "link": "https://naruto.fandom.com/pt-br/wiki/Cl%C3%A3_de_J%C5%ABgo",
        "icon": "",
        "name": "Cla de Jugo",
        "id": 11
    },
    {
        "link": "https://naruto.fandom.com/pt-br/wiki/Cl%C3%A3_Kaguya",
        "icon": "https://static.wikia.nocookie.net/naruto/images/f/f9/S%C3%ADmbolo_Cl%C3%A3_Kaguya.svg/revision/latest/scale-to-width-down/70?cb=20121117155548&path-prefix=pt-br",
        "name": "Cla Kaguya",
        "id": 12
    },
    {
        "link": "https://naruto.fandom.com/pt-br/wiki/Cl%C3%A3_Kamizuru",
        "icon": "https://static.wikia.nocookie.net/naruto/images/1/1e/S%C3%ADmbolo_Cl%C3%A3_Kamizuru.svg/revision/latest/scale-to-width-down/70?cb=20151007030807&path-prefix=pt-br",
        "name": "Cla Kamizuru",
        "id": 13
    },
    {
        "link": "https://naruto.fandom.com/pt-br/wiki/Cl%C3%A3_Ked%C5%8Din",
        "icon": "https://static.wikia.nocookie.net/naruto/images/5/57/S%C3%ADmbolo_Cl%C3%A3_Ked%C5%8Din.svg/revision/latest/scale-to-width-down/70?cb=20130225031102&path-prefix=pt-br",
        "name": "Cla Kedoin",
        "id": 14
    },
    {
        "link": "https://naruto.fandom.com/pt-br/wiki/Cl%C3%A3_Kohaku",
        "icon": "https://static.wikia.nocookie.net/naruto/images/f/f1/S%C3%ADmbolo_Cl%C3%A3_Kohaku.svg/revision/latest/scale-to-width-down/70?cb=20130723153520&path-prefix=pt-br",
        "name": "Cla Kohaku",
        "id": 15
    },
    {
        "link": "https://naruto.fandom.com/pt-br/wiki/Cl%C3%A3_Kubisaki",
        "icon": "",
        "name": "Cla Kubisaki",
        "id": 16
    },
    {
        "link": "https://naruto.fandom.com/pt-br/wiki/Cl%C3%A3_Kurama",
        "icon": "https://static.wikia.nocookie.net/naruto/images/1/1d/S%C3%ADmbolo_Kurama.svg/revision/latest/scale-to-width-down/70?cb=20130225202454&path-prefix=pt-br",
        "name": "Cla Kurama",
        "id": 17
    },
    {
        "link": "https://naruto.fandom.com/pt-br/wiki/Cl%C3%A3_Nara",
        "icon": "https://static.wikia.nocookie.net/naruto/images/3/39/S%C3%ADmbolo_Cl%C3%A3_Nara.svg/revision/latest/scale-to-width-down/70?cb=20121117153914&path-prefix=pt-br",
        "name": "Cla Nara",
        "id": 18
    },
    {
        "link": "https://naruto.fandom.com/pt-br/wiki/Cl%C3%A3_Rinha",
        "icon": "https://static.wikia.nocookie.net/naruto/images/3/38/S%C3%ADmbolo_Cl%C3%A3_Rinha.svg/revision/latest/scale-to-width-down/70?cb=20150510023849&path-prefix=pt-br",
        "name": "Cla Rinha",
        "id": 19
    },
    {
        "link": "https://naruto.fandom.com/pt-br/wiki/Cl%C3%A3_Ry%C5%AB",
        "icon": "https://static.wikia.nocookie.net/naruto/images/9/93/S%C3%ADmbolo_Cl%C3%A3_Ry%C5%AB.svg/revision/latest/scale-to-width-down/70?cb=20151005040435&path-prefix=pt-br",
        "name": "Cla Ryu",
        "id": 20
    },
    {
        "link": "https://naruto.fandom.com/pt-br/wiki/Cl%C3%A3_Sarutobi",
        "icon": "https://static.wikia.nocookie.net/naruto/images/8/89/S%C3%ADmbolo_Cl%C3%A3_Sarutobi.svg/revision/latest/scale-to-width-down/70?cb=20151027001416&path-prefix=pt-br",
        "name": "Cla Sarutobi",
        "id": 21
    },
    {
        "link": "https://naruto.fandom.com/pt-br/wiki/Cl%C3%A3_Senju",
        "icon": "https://static.wikia.nocookie.net/naruto/images/3/35/S%C3%ADmbolo_Cl%C3%A3_Senju.svg/revision/latest/scale-to-width-down/70?cb=20121117153741&path-prefix=pt-br",
        "name": "Cla Senju",
        "id": 22
    },
    {
        "link": "https://naruto.fandom.com/pt-br/wiki/Cl%C3%A3_Shiin",
        "icon": "https://static.wikia.nocookie.net/naruto/images/6/69/S%C3%ADmbolo_Cl%C3%A3_Shiin.svg/revision/latest/scale-to-width-down/70?cb=20130605205639&path-prefix=pt-br",
        "name": "Cla Shiin",
        "id": 23
    },
    {
        "link": "https://naruto.fandom.com/pt-br/wiki/Cl%C3%A3_Shimura",
        "icon": "",
        "name": "Cla Shimura",
        "id": 24
    },
    {
        "link": "https://naruto.fandom.com/pt-br/wiki/Cl%C3%A3_Shirogane",
        "icon": "https://static.wikia.nocookie.net/naruto/images/5/57/S%C3%ADmbolo_do_Cl%C3%A3_Shirogane.svg/revision/latest/scale-to-width-down/70?cb=20141122201116&path-prefix=pt-br",
        "name": "Cla Shirogane",
        "id": 25
    },
    {
        "link": "https://naruto.fandom.com/pt-br/wiki/Cl%C3%A3_Tenr%C5%8D",
        "icon": "https://static.wikia.nocookie.net/naruto/images/2/26/S%C3%ADmbolo_Tenro.svg/revision/latest/scale-to-width-down/70?cb=20141024212227&path-prefix=pt-br",
        "name": "Cla Tenro",
        "id": 26
    },
    {
        "link": "https://naruto.fandom.com/pt-br/wiki/Cl%C3%A3_Tsuchigumo",
        "icon": "https://static.wikia.nocookie.net/naruto/images/5/57/S%C3%ADmbolo_Tsuchigumo.svg/revision/latest/scale-to-width-down/70?cb=20131217154823&path-prefix=pt-br",
        "name": "Cla Tsuchigumo",
        "id": 27
    },
    {
        "link": "https://naruto.fandom.com/pt-br/wiki/Cl%C3%A3_Uchiha",
        "icon": "https://static.wikia.nocookie.net/naruto/images/8/85/S%C3%ADmbolo_Cl%C3%A3_Uchiha.svg/revision/latest/scale-to-width-down/70?cb=20120914213218&path-prefix=pt-br",
        "name": "Cla Uchiha",
        "id": 28
    },
    {
        "link": "https://naruto.fandom.com/pt-br/wiki/Cl%C3%A3_Uzumaki",
        "icon": "https://static.wikia.nocookie.net/naruto/images/2/23/S%C3%ADmbolo_Cl%C3%A3_Uzumaki.svg/revision/latest/scale-to-width-down/70?cb=20150816002851&path-prefix=pt-br",
        "name": "Cla Uzumaki",
        "id": 29
    },
    {
        "link": "https://naruto.fandom.com/pt-br/wiki/Fam%C3%ADlia_Wagarashi",
        "icon": "",
        "name": "Familia Wagarashi",
        "id": 30
    },
    {
        "link": "https://naruto.fandom.com/pt-br/wiki/Fam%C3%ADlia_Wasabi",
        "icon": "",
        "name": "Familia Wasabi",
        "id": 31
    },
    {
        "link": "https://naruto.fandom.com/pt-br/wiki/Watari_Ninja",
        "icon": "",
        "name": "Watari Ninja",
        "id": 32
    },
    {
        "link": "https://naruto.fandom.com/pt-br/wiki/Cl%C3%A3_Yamanaka",
        "icon": "https://static.wikia.nocookie.net/naruto/images/0/0b/S%C3%ADmbolo_Cl%C3%A3_Yamanaka.svg/revision/latest/scale-to-width-down/70?cb=20120928011913&path-prefix=pt-br",
        "name": "Cla Yamanaka",
        "id": 33
    },
    {
        "link": "https://naruto.fandom.com/pt-br/wiki/Cl%C3%A3_Otenki",
        "icon": "",
        "name": "Cla Otenki",
        "id": 34
    },
    {
        "link": "https://naruto.fandom.com/pt-br/wiki/Cl%C3%A3_Yotsuki",
        "icon": "https://static.wikia.nocookie.net/naruto/images/f/f9/S%C3%ADmbolo_Cl%C3%A3_Yotsuki.svg/revision/latest/scale-to-width-down/70?cb=20121117155818&path-prefix=pt-br",
        "name": "Cla Yotsuki",
        "id": 35
    }
]""".replace('\\', '/').trimIndent()
}

fun getImageFromClan(nameClan: String): String {
    val arrayTutorialType = object : TypeToken<List<ClansResponseV2>>() {}.type
    val images: List<ClansResponseV2> = Gson().fromJson(getClansApiImages(), arrayTutorialType)
    images.forEach {
        if (it.name.contains(nameClan)) {
            return it.icon
        }
    }
    return ""
}