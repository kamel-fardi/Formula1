package com.kamelfardi.formula1.Utils

import com.kamelfardi.formula1.R

enum class Avatar(val drawableResId: Int) {
    ALBON(R.drawable.albon),
    Hamilton(R.drawable.hamilton),
    Sainz(R.drawable.sainz),
    Leclerc(R.drawable.leclerc),
    Perez(R.drawable.perez),
    Russell(R.drawable.russell),
    Piastri(R.drawable.piastri),
    Norris(R.drawable.norris),
    ALONSO(R.drawable.alonso),
    GASLY(R.drawable.gasly),
    HULKENBERG(R.drawable.hulkenberg),
    TSUNODA(R.drawable.tsunoda),
    STROLL(R.drawable.stroll),
    OCON(R.drawable.ocon),
    MAGNUSSEN(R.drawable.magnussen),
    RICCIARDO(R.drawable.magnussen),
    PANIS(R.drawable.bearman),
    COLAPINTO(R.drawable.colapinto),
    ZHOU(R.drawable.zhou),
    LAWSON(R.drawable.lawson),
    BOTTAS(R.drawable.bottas),
    SARGEANT(R.drawable.bottas),
    AITKEN(R.drawable.doohan),
    VERSTAPPEN(R.drawable.verstappen);


    companion object {
        fun fromDriverName(driverName: String): Avatar? {
            return values().find { it.name.lowercase() == driverName.lowercase() }
        }
    }

    // Renamed the function to avoid the conflict
    fun getDrawableResourceId(): Int {
        return drawableResId
    }
}

enum class Circuitimage(val drawableResId: Int) {
    ALBERT_PARK(R.drawable.albert_park),
    BAKU(R.drawable.baku),
    BAHRAIN(R.drawable.bahrain),
    CATALUNYA(R.drawable.catalunya),
    IMOLA(R.drawable.imola),
    INTERLAGOS(R.drawable.interlagos),
    MONACO(R.drawable.monaco),
    MONZA(R.drawable.monza),
    SILVERSTONE(R.drawable.silverstone),
    AUSTIN(R.drawable.austin),
    SUZUKA(R.drawable.suzuka),
    SPA(R.drawable.spa),
    MIAMI(R.drawable.miami),
    JEDDAH(R.drawable.jeddah),
    HUNGARORING(R.drawable.hungaroring),
    SHANGHAI(R.drawable.shanghai),
    LOSAIL(R.drawable.losail),
    RODRIGUEZ(R.drawable.rodriguez),
    VEGAS(R.drawable.vegas),
    VILLENEUVE(R.drawable.villeneuve),
    YAS_MARINA(R.drawable.yas_marina),
    ZANDVOORT(R.drawable.zandvoort),
    RED_BULL_RING(R.drawable.red_bull_ring);


    companion object {
        fun fromCircuitName(circuitId: String): Circuitimage? {
            return Circuitimage.values().find { it.name.lowercase() == circuitId.lowercase() }
        }
    }


    fun getDrawableResourceId(): Int {
        return drawableResId
    }
}
enum class flags(val drawableResId: Int) {
    USA(R.drawable.usa_flag),
    AUSTRIA(R.drawable.austria_flag),
    BAHRAIN(R.drawable.bahrain_flag),
    AZERBAIJAN(R.drawable.azerbaijan_flag),
    SPAIN(R.drawable.spain_flag),
    MONACO(R.drawable.monaco_flag),
    CANADA(R.drawable.canada_flag),
    FRANCE(R.drawable.france_flag),
    GREAT_BRITAIN(R.drawable.great_britain_flag),
    HUNGARY(R.drawable.hungary_flag),
    BELGIUM(R.drawable.belgium_flag),
    NETHERLANDS(R.drawable.netherlands_flag),
    ITALY(R.drawable.italy_flag),
    MEXICO(R.drawable.mexico_flag),
    BRAZIL(R.drawable.brazil_flag),
    AUSTRALIA(R.drawable.australia_flag),
    SAUDI_ARABIA(R.drawable.saudi_arabia_flag),
    QATAR(R.drawable.qatar_flag),
    JAPAN(R.drawable.japan_flag),
    ARGENTINA(R.drawable.argentina_flag),
    GERMAN(R.drawable.germany_flag),
    DENMARK(R.drawable.denmark_flag),
    FINLAND(R.drawable.finland_flag),
    THAILAND(R.drawable.thailand_flag),
    SINAGPORE(R.drawable.singapore_flag),
    UAE(R.drawable.uae_flag),
    UNITED_STATES(R.drawable.usa_flag),
    UK(R.drawable.uk_flag),

    CHINA(R.drawable.china_flag);

    companion object {
        fun fromCountryName(countryName: String): flags? {
            return flags.values()
                .find { it.name.replace("_", " ").lowercase() == countryName.lowercase() }
        }
    }
        fun getDrawableResourceId(): Int {
            return drawableResId
        }
    }









