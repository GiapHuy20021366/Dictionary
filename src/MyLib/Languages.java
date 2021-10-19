package MyLib; 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.swing.ListSelectionModel;

public class Languages {
    // Code of Languages.
    public static final String Afrikaans = "af";
    public static final String Arabic = "ar";
    public static final String Azeri = "az";
    public static final String Belarusian = "be";
    public static final String Bulgarian = "bg";
    public static final String Bosnian = "bs";
    public static final String Catalan = "ca";
    public static final String Czech = "cs";
    public static final String Welsh = "cy";
    public static final String Danish = "da";
    public static final String German = "de";
    public static final String Divehi = "dv";
    public static final String Greek = "el";
    public static final String English = "en";
    public static final String Esperanto = "eo";
    public static final String Spanish = "es";
    public static final String Estonian = "et";
    public static final String Basque = "eu";
    public static final String Farsi = "fa";
    public static final String Finnish = "fi";
    public static final String Faroese = "fo";
    public static final String French = "fr";
    public static final String Galician = "gl";
    public static final String Gujarati = "gu";
    public static final String Hebrew = "he";
    public static final String Hindi = "hi";
    public static final String Croatian = "hr";
    public static final String Hungarian = "hu";
    public static final String Armenian = "hy";
    public static final String Indonesian = "id";
    public static final String Icelandic = "is";
    public static final String Italian = "it";
    public static final String Japanese = "ja";
    public static final String Georgian = "ka";
    public static final String Kazakh = "kk";
    public static final String Kannada = "kn";
    public static final String Korean = "ko";
    public static final String Konkani = "kok";
    public static final String Kyrgyz = "ky";
    public static final String Lithuanian = "lt";
    public static final String Latvian = "lv";
    public static final String Maori = "mi";
    public static final String Macedonian = "mk";
    public static final String Mongolian = "mn";
    public static final String Marathi = "mr";
    public static final String Malay = "ms";
    public static final String Maltese = "mt";
    public static final String Norwegian = "nn";
    public static final String  Dutch = "nl";
    public static final String Sotho = "ns";
    public static final String Punjabi = "pa";
    public static final String Polish = "pl";
    public static final String Pashto = "ps";
    public static final String Portuguese = "pt";
    public static final String Quechua = "qu";
    public static final String Romanian = "ro";
    public static final String Russian = "ru";
    public static final String Sanskrit = "sa";
    public static final String Sami = "se";
    public static final String Slovak = "sk";
    public static final String Slovenian = "sl";
    public static final String Albanian = "sq";
    public static final String Serbian = "sr";
    public static final String Swedish = "sv";
    public static final String Swahili = "sw";
    public static final String Syriac = "syr";
    public static final String Tamil = "ta";
    public static final String Telugu = "te";
    public static final String Thai = "th";
    public static final String Tagalog = "tl";
    public static final String Tswana = "tn";
    public static final String Turkish = "tr";
    public static final String Tatar = "tt";
    public static final String Tsonga = "ts";
    public static final String Ukrainian = "uk";
    public static final String Urdu = "ur";
    public static final String Uzbek = "uz";
    public static final String Vietnamese = "vi";
    public static final String Xhosa = "xh";
    public static final String Chinese = "zh";
    public static final String HongKong = "zh-hk";
    public static final String Taiwan = "zh-tw";
    public static final String Zulu = "zu";

    public static String codeOf(String language) {
        language = language.trim();
        if (language.equalsIgnoreCase("Afrikaans")) {
            return "af";
        } else if (language.equalsIgnoreCase("Arabic")) {
            return "ar";
        } else if (language.equalsIgnoreCase("Azeri")) {
            return "ar";
        } else if (language.equalsIgnoreCase("Belarusian")) {
            return "be";
        } else if (language.equalsIgnoreCase("Bulgarian")) {
            return "bg";
        } else if (language.equalsIgnoreCase("Bosnian")) {
            return "bs";
        } else if (language.equalsIgnoreCase("Catalan")) {
            return "ca";
        } else if (language.equalsIgnoreCase("Czech")) {
            return "cs";
        } else if (language.equalsIgnoreCase("Welsh")) {
            return "cy";
        } else if (language.equalsIgnoreCase("Danish")) {
            return "da";
        } else if (language.equalsIgnoreCase("German")) {
            return "de";
        } else if (language.equalsIgnoreCase("Divehi")) {
            return "dv";
        } else if (language.equalsIgnoreCase("Greek")) {
            return "el";
        } else if (language.equalsIgnoreCase("English")) {
            return "en";
        } else if (language.equalsIgnoreCase("Esperanto")) {
            return "eo";
        } else if (language.equalsIgnoreCase("Spanish")) {
            return "es";
        } else if (language.equalsIgnoreCase("Estonian")) {
            return "et";
        } else if (language.equalsIgnoreCase("Basque")) {
            return "eu";
        } else if (language.equalsIgnoreCase("Farsi")) {
            return "fa";
        } else if (language.equalsIgnoreCase("Finnish")) {
            return "fi";
        } else if (language.equalsIgnoreCase("Faroese")) {
            return "fo";
        } else if (language.equalsIgnoreCase("French")) {
            return "fr";
        } else if (language.equalsIgnoreCase("Galician")) {
            return "gl";
        } else if (language.equalsIgnoreCase("Gujarati")) {
            return "gu";
        } else if (language.equalsIgnoreCase("Hebrew")) {
            return "he";
        } else if (language.equalsIgnoreCase("Hindi")) {
            return "hi";
        } else if (language.equalsIgnoreCase("Croatian")) {
            return "hr";
        } else if (language.equalsIgnoreCase("Hungarian")) {
            return "hu";
        } else if (language.equalsIgnoreCase("Armenian")) {
            return "hy";
        } else if (language.equalsIgnoreCase("Indonesian")) {
            return "id";
        } else if (language.equalsIgnoreCase("Icelandic")) {
            return "is";
        } else if (language.equalsIgnoreCase("Italian")) {
            return "it";
        } else if (language.equalsIgnoreCase("Japanese")) {
            return "ja";
        } else if (language.equalsIgnoreCase("Georgian")) {
            return "ka";
        } else if (language.equalsIgnoreCase("Kazakh")) {
            return "kk";
        } else if (language.equalsIgnoreCase("Kannada")) {
            return "kn";
        } else if (language.equalsIgnoreCase("Korean")) {
            return "ko";
        } else if (language.equalsIgnoreCase("Konkani")) {
            return "kok";
        } else if (language.equalsIgnoreCase("Kyrgyz")) {
            return "ky";
        } else if (language.equalsIgnoreCase("Lithuanian")) {
            return "lt";
        } else if (language.equalsIgnoreCase("Latvian")) {
            return "lv";
        } else if (language.equalsIgnoreCase("Maori")) {
            return "mi";
        } else if (language.equalsIgnoreCase("Macedonian")) {
            return "mk";
        } else if (language.equalsIgnoreCase("Mongolian")) {
            return "mn";
        } else if (language.equalsIgnoreCase("Marathi")) {
            return "mr";
        } else if (language.equalsIgnoreCase("Malay")) {
            return "ms";
        } else if (language.equalsIgnoreCase("Maltese")) {
            return "mt";
        } else if (language.equalsIgnoreCase("Norwegian")) {
            return "nn";
        } else if (language.equalsIgnoreCase("Dutch")) {
            return "nl";
        } else if (language.equalsIgnoreCase("Sotho")) {
            return "ns";
        } else if (language.equalsIgnoreCase("Punjabi")) {
            return "pa";
        } else if (language.equalsIgnoreCase("Polish")) {
            return "pl";
        } else if (language.equalsIgnoreCase("Pashto")) {
            return "ps";
        } else if (language.equalsIgnoreCase("Portuguese")) {
            return "pt";
        } else if (language.equalsIgnoreCase("Quechua")) {
            return "qu";
        } else if (language.equalsIgnoreCase("Romanian")) {
            return "ro";
        } else if (language.equalsIgnoreCase("Russian")) {
            return "ru";
        } else if (language.equalsIgnoreCase("Sanskrit")) {
            return "sa";
        } else if (language.equalsIgnoreCase("Sami")) {
            return "se";
        } else if (language.equalsIgnoreCase("Slovak")) {
            return "sk";
        } else if (language.equalsIgnoreCase("Slovenian")) {
            return "ar";
        } else if (language.equalsIgnoreCase("Albanian")) {
            return "sl";
        } else if (language.equalsIgnoreCase("Serbian")) {
            return "sr";
        } else if (language.equalsIgnoreCase("Swedish")) {
            return "sv";
        } else if (language.equalsIgnoreCase("Swahili")) {
            return "sw";
        } else if (language.equalsIgnoreCase("Syriac")) {
            return "syr";
        } else if (language.equalsIgnoreCase("Tamil")) {
            return "ta";
        } else if (language.equalsIgnoreCase("Telugu")) {
            return "te";
        } else if (language.equalsIgnoreCase("Thai")) {
            return "th";
        } else if (language.equalsIgnoreCase("Tagalog")) {
            return "tl";
        } else if (language.equalsIgnoreCase("Tswana")) {
            return "tn";
        } else if (language.equalsIgnoreCase("Turkish")) {
            return "tr";
        } else if (language.equalsIgnoreCase("Tatar")) {
            return "tt";
        } else if (language.equalsIgnoreCase("Tsonga")) {
            return "ts";
        } else if (language.equalsIgnoreCase("Ukrainian")) {
            return "uk";
        } else if (language.equalsIgnoreCase("Urdu")) {
            return "ur";
        } else if (language.equalsIgnoreCase("Uzbek")) {
            return "uz";
        } else if (language.equalsIgnoreCase("Vietnamese")) {
            return "vi";
        } else if (language.equalsIgnoreCase("Xhosa")) {
            return "xh";
        } else if (language.equalsIgnoreCase("Chinese")) {
            return "zh";
        } else if (language.equalsIgnoreCase("HongKong")) {
            return HongKong;
        } else if (language.equalsIgnoreCase("Taiwan")) {
            return Taiwan;
        } else if (language.equalsIgnoreCase("Zulu")) {
            return "zu";
        }
        return null;
    }

    public static String languageOf(String code) {
        if (code.equals(Afrikaans)) {
            return "Afrikaans";
        } else if (code.equals(	Arabic)) {
            return "Arabic";
        } else if (code.equals(Azeri)) {
            return "Azeri";
        } else if (code.equals(Belarusian)) {
            return "Belarusian";
        } else if (code.equals(Bulgarian)) {
            return "Bulgarian";
        } else if (code.equals(Bosnian)) {
            return "Bosnian";
        } else if (code.equals(Catalan)) {
            return "Catalan";
        } else if (code.equals(Czech)) {
            return "Czech";
        } else if (code.equals(Welsh)) {
            return "Welsh";
        } else if (code.equals(Danish)) {
            return "Danish";
        } else if (code.equals(German)) {
            return "German";
        } else if (code.equals(Divehi)) {
            return "Divehi";
        } else if (code.equals(Greek)) {
            return "Greek";
        } else if (code.equals(English)) {
            return "English";
        } else if (code.equals(Esperanto)) {
            return "Esperanto";
        } else if (code.equals(Spanish)) {
            return "Spanish";
        } else if (code.equals(Estonian)) {
            return "Estonian";
        } else if (code.equals(Basque)) {
            return "Basque";
        } else if (code.equals(	Farsi)) {
            return "Farsi";
        } else if (code.equals(Finnish)) {
            return "Finnish";
        } else if (code.equals(Faroese)) {
            return "Faroese";
        } else if (code.equals(French)) {
            return "French";
        } else if (code.equals(Galician)) {
            return "Galician";
        } else if (code.equals(Gujarati)) {
            return "Gujarati";
        } else if (code.equals(Hebrew)) {
            return "Hebrew";
        } else if (code.equals(Hindi)) {
            return "Hindi";
        } else if (code.equals(Croatian)) {
            return "Croatian";
        } else if (code.equals(Hungarian)) {
            return "Hungarian";
        } else if (code.equals(	Armenian)) {
            return "Armenian";
        } else if (code.equals(Indonesian)) {
            return "Indonesian";
        } else if (code.equals(Icelandic)) {
            return "Icelandic";
        } else if (code.equals(Italian)) {
            return "Italian";
        } else if (code.equals(Japanese)) {
            return "Japanese";
        } else if (code.equals(	Georgian)) {
            return "Georgian";
        } else if (code.equals(Kazakh)) {
            return "Kazakh";
        } else if (code.equals(Kannada)) {
            return "Kannada";
        } else if (code.equals(Korean)) {
            return "Korean";
        } else if (code.equals(Konkani)) {
            return "Konkani";
        } else if (code.equals(Kyrgyz)) {
            return "Kyrgyz";
        } else if (code.equals(Lithuanian)) {
            return "Lithuanian";
        } else if (code.equals(Latvian)) {
            return "Latvian";
        } else if (code.equals(	Maori)) {
            return "Maori";
        } else if (code.equals(Macedonian)) {
            return "Macedonian";
        } else if (code.equals(Mongolian)) {
            return "Mongolian";
        } else if (code.equals(Marathi)) {
            return "Marathi";
        } else if (code.equals(Malay)) {
            return "Malay";
        } else if (code.equals(Maltese)) {
            return "Maltese";
        } else if (code.equals(Norwegian)) {
            return "Norwegian";
        } else if (code.equals(Dutch)) {
            return "Dutch";
        } else if (code.equals(Sotho)) {
            return "Sotho";
        } else if (code.equals(	Punjabi)) {
            return "Punjabi";
        } else if (code.equals(Polish)) {
            return "Polish";
        } else if (code.equals(Pashto)) {
            return "Pashto";
        } else if (code.equals(	Portuguese)) {
            return "Portuguese";
        } else if (code.equals(	Quechua)) {
            return "Quechua";
        } else if (code.equals(Romanian)) {
            return "Romanian";
        } else if (code.equals(Russian)) {
            return "Russian";
        } else if (code.equals(Russian)) {
            return "Russian";
        } else if (code.equals(Sanskrit)) {
            return "Sanskrit";
        } else if (code.equals(Sami)) {
            return "Sami";
        } else if (code.equals(Slovak)) {
            return "Slovak";
        } else if (code.equals(Slovenian)) {
            return "Slovenian";
        } else if (code.equals(Albanian)) {
            return "Albanian";
        } else if (code.equals(Serbian)) {
            return "Serbian";
        } else if (code.equals(	Swedish)) {
            return "Swedish";
        } else if (code.equals(Swahili)) {
            return "Swahili";
        } else if (code.equals(Syriac)) {
            return "Syriac";
        } else if (code.equals(Tamil)) {
            return "Tamil";
        } else if (code.equals(Telugu)) {
            return "Telugu";
        } else if (code.equals(	Thai)) {
            return "Thai";
        } else if (code.equals(Tagalog)) {
            return "Tagalog";
        } else if (code.equals(Tswana)) {
            return "Tswana";
        } else if (code.equals(Turkish)) {
            return "Turkish";
        } else if (code.equals(Tatar)) {
            return "Tatar";
        } else if (code.equals(Tsonga)) {
            return "Tsonga";
        } else if (code.equals(Ukrainian)) {
            return "Ukrainian";
        } else if (code.equals(Urdu)) {
            return "Urdu";
        } else if (code.equals(Uzbek)) {
            return "Uzbek";
        } else if (code.equals(Vietnamese)) {
            return "Vietnamese";
        } else if (code.equals(Xhosa)) {
            return "Xhosa";
        } else if (code.equals(Chinese)) {
            return "Chinese";
        } else if (code.equals(HongKong)) {
            return "HongKong";
        } else if (code.equals(Taiwan)) {
            return "Taiwan";
        } else if (code.equals(Zulu)) {
            return "Zulu";
        }
        return null;
    }

    public static String[] listVoicesOf(String language) {
        if (language.equalsIgnoreCase("Arabic")) {
            return new String[]{"Salim"};
        }
        if (language.equalsIgnoreCase("Bulgarian")) {
            return new String[]{"Dimo"};
        }
        if (language.equalsIgnoreCase("Catalan")) {
            return new String[]{"Rut"};
        }
        if (language.equalsIgnoreCase("Chinese")) {
            return new String[]{"Luli", "Wang","Chow", "Shu"};
        }
        if (language.equalsIgnoreCase("HongKong")) {
            return new String[]{"Jia", "Chen","Xia"};
        }
        if (language.equalsIgnoreCase("Taiwan")) {
            return new String[]{"Akemi", "Lee", "Lin"};
        }
        if (language.equalsIgnoreCase("Croatian")) {
            return new String[]{"Nikola"};
        }
        if (language.equalsIgnoreCase("Czech")) {
            return new String[]{"Josef"};
        }
        if (language.equalsIgnoreCase("Danish")) {
            return new String[]{"Freja"};
        }
        if (language.equalsIgnoreCase("Dutch")) {
            return new String[]{"Lotte","Bram"};
        }
        if (language.equalsIgnoreCase("English")) {
            return new String[]{"Linda","Amy","Mary","John","Mike"};
        }
        if (language.equalsIgnoreCase("Finnish")) {
            return new String[]{"Aada"};
        }
        if (language.equalsIgnoreCase("French")) {
            return new String[]{"Bette", "Iva", "Zola","Axel"};
        }
        if (language.equalsIgnoreCase("German")) {
            return new String[]{"Tim"};
        }
        if (language.equalsIgnoreCase("Greek")) {
            return new String[]{"Neo"};
        }
        if (language.equalsIgnoreCase("Hebrew")) {
            return new String[]{"Rami"};
        }
        if (language.equalsIgnoreCase("Hindi")) {
            return new String[]{"Puja", "Kabir"};
        }
        if (language.equalsIgnoreCase("Hungarian")) {
            return new String[]{"Mate"};
        }
        if (language.equalsIgnoreCase("Indonesian")) {
            return new String[]{"Intan"};
        }
        if (language.equalsIgnoreCase("Italian")) {
            return new String[]{"Bria",  "Pietro","Mia"};
        }
        if (language.equalsIgnoreCase("Japanese")) {
            return new String[]{"Hina", "Airi", "Akira", "Fumi"};
        }
        if (language.equalsIgnoreCase("Korean")) {
            return new String[]{"Nari"};
        }
        if (language.equalsIgnoreCase("Malay")) {
            return new String[]{"Aqil"};
        }
        if (language.equalsIgnoreCase("Norwegian")) {
            return new String[]{"Marte","Erik"};
        }
        if (language.equalsIgnoreCase("Polish")) {
            return new String[]{"Julia","Jan"};
        }
        if (language.equalsIgnoreCase("Portuguese")) {
            return new String[]{"Leonor"};
        }
        if (language.equalsIgnoreCase("Romanian")) {
            return new String[]{"Doru"};
        }
        if (language.equalsIgnoreCase("Russian")) {
            return new String[]{"Olga","Marina","Peter"};
        }
        if (language.equalsIgnoreCase("Slovak")) {
            return new String[]{"Beda"};
        }
        if (language.equalsIgnoreCase("Slovenian")) {
            return new String[]{"Vid"};
        }
        if (language.equalsIgnoreCase("Spanish")) {
            return new String[]{"Camila","Sofía","Diego","Luna"};
        }
        if (language.equalsIgnoreCase("Swedish")) {
            return new String[]{"Molly","Hugo"};
        }
        if (language.equalsIgnoreCase("Thai")) {
            return new String[]{"Ukrit"};
        }
        if (language.equalsIgnoreCase("Turkish")) {
            return new String[]{"Omer"};
        }
        if (language.equalsIgnoreCase("Vietnamese")) {
            return new String[]{"Chi"};
        }
        return null;
    }

    public static String codeVoiceOf(String language) {
        if (language.equalsIgnoreCase("Catalan")) {
            return "ca-es";
        }
        if (language.equalsIgnoreCase("Chinese")) {
            return "zh-cn";
        }
        if (language.equalsIgnoreCase("HongKong")) {
            return "zh-hk";
        }
        if (language.equalsIgnoreCase("Taiwan")) {
            return "zh-tw";
        }
        if (language.equalsIgnoreCase("Danish")) {
            return "da-dk";
        }
        if (language.equalsIgnoreCase("Dutch")) {
            return "nl-nl";
        }
        if (language.equalsIgnoreCase("English")) {
            return "en-us";
        }
        if (language.equalsIgnoreCase("Finnish")) {
            return "fi-fi";
        }
        if (language.equalsIgnoreCase("French")) {
            return "fr-fr";
        }
        if (language.equalsIgnoreCase("German")) {
            return "de-de";
        }
        if (language.equalsIgnoreCase("Italian")) {
            return "it-it";
        }
        if (language.equalsIgnoreCase("Japanese")) {
            return "ja-jp";
        }
        if (language.equalsIgnoreCase("Korean")) {
            return "ko-kr";
        }
        if (language.equalsIgnoreCase("Norwegian")) {
            return "nb-no";
        }
        if (language.equalsIgnoreCase("Polish")) {
            return "pl-pl";
        }
        if (language.equalsIgnoreCase("Portuguese")) {
            return "pt-pt";
        }
        if (language.equalsIgnoreCase("Russian")) {
            return "ru-ru";
        }
        if (language.equalsIgnoreCase("Spanish")) {
            return "es-es";
        }
        if (language.equalsIgnoreCase("Swedish")) {
            return "sv-se";
        }
        if (language.equalsIgnoreCase("Romanian")) {
            return "ro-ro";
        }
        if (language.equalsIgnoreCase("Tamil")) {
            return "ta-in";
        }
        if (language.equalsIgnoreCase("Thai")) {
            return "th-th";
        }
        if (language.equalsIgnoreCase("Turkish")) {
            return "tr_TR";
        }
        if (language.equalsIgnoreCase("Vietnamese")) {
            return "vi-vn";
        }
        if (language.equalsIgnoreCase("Arabic")) {
            return "ar-sa";
        }
        if (language.equalsIgnoreCase("Bulgarian")) {
            return "bg-bg";
        }
        if (language.equalsIgnoreCase("Croatian")) {
            return "hr-hr";
        }
        if (language.equalsIgnoreCase("Czech")) {
            return "cs-cz";
        }
        if (language.equalsIgnoreCase("Greek")) {
            return "el-gr";
        }
        if (language.equalsIgnoreCase("Hebrew")) {
            return "he-il";
        }
        if (language.equalsIgnoreCase("Hindi")) {
            return "hi-in";
        }
        if (language.equalsIgnoreCase("Hungarian")) {
            return "hu-hu";
        }
        if (language.equalsIgnoreCase("Indonesian")) {
            return "id-id";
        }
        if (language.equalsIgnoreCase("Malay")) {
            return "ms-my";
        }
        if (language.equalsIgnoreCase("Slovak")) {
            return "sk-sk";
        }
        if (language.equalsIgnoreCase("Slovenian")) {
            return "sl-si";
        }
        return null;

    }

    public static Boolean isSupportVoiceInVietnamese(String language ) {
    	String code = getCodeOfLanguageInVietnamese(language);
    	
        return codeVoiceOf(languageOf(code)) != null;
    }

    public static HashMap<String, String> allLanguageSupported = null;

    public static void loadLanguages() {
    	if (allLanguageSupported != null) {
    		return;
    	}
        allLanguageSupported = new HashMap<>();
        allLanguageSupported.put("Tiếng Afrikaans", "Afrikaans");
        allLanguageSupported.put("Tiếng Ả Rập", "Arabic");
        allLanguageSupported.put("Tiếng Azeri", "Azeri");
        allLanguageSupported.put("Tiếng Belarus", "Belarusian");
        allLanguageSupported.put("Tiếng Bungari", "Bulgarian");
        allLanguageSupported.put("Tiếng Bosnia", "Bosnian");
        allLanguageSupported.put("Tiếng Catala", "Catalan");
        allLanguageSupported.put("Tiếng Séc", "Czech");
        allLanguageSupported.put("Tiếng Xứ Wales", "Welsh");
        allLanguageSupported.put("Tiếng Đan Mạch", "Danish");
        allLanguageSupported.put("Tiếng Đức", "German");
        allLanguageSupported.put("Tiếng Divehi", "Divehi");
        allLanguageSupported.put("Tiếng Hy Lạp", "Greek");
        allLanguageSupported.put("Tiếng Anh", "English");
        allLanguageSupported.put("Tiếng Esperanto", "Esperanto");
        allLanguageSupported.put("Tiếng Tây Ban Nha", "Spanish");
        allLanguageSupported.put("Tiếng Estonia", "Estonian");
        allLanguageSupported.put("Tiếng Xứ Basque", "Basque");
        allLanguageSupported.put("Tiếng Farsi", "Farsi");
        allLanguageSupported.put("Tiếng Phần Lan", "Finnish");
        allLanguageSupported.put("Tiếng Faroese", "Faroese");
        allLanguageSupported.put("Tiếng Pháp", "French");
        allLanguageSupported.put("Tiếng Galicia", "Galician");
        allLanguageSupported.put("Tiếng Gujarati", "Gujarati");
        allLanguageSupported.put("Tiếng Do Thái", "Hebrew");
        allLanguageSupported.put("Tiếng Hindi", "Hindi");
        allLanguageSupported.put("Tiếng Croatia", "Croatian");
        allLanguageSupported.put("Tiếng Hungary", "Hungarian");
        allLanguageSupported.put("Tiếng Armenia", "Armenian");
        allLanguageSupported.put("Tiếng Indonesia", "Indonesian");
        allLanguageSupported.put("Tiếng Icelandic", "Icelandic");
        allLanguageSupported.put("Tiếng Ý", "Italian");
        allLanguageSupported.put("Tiếng Nhật", "Japanese");
        allLanguageSupported.put("Tiếng Gruzia", "Georgian");
        allLanguageSupported.put("Tiếng Kazakh", "Kazakh");
        allLanguageSupported.put("Tiếng Kannada", "Kannada");
        allLanguageSupported.put("Tiếng Hàn Quốc", "Korean");
        allLanguageSupported.put("Tiếng Konkani", "Konkani");
        allLanguageSupported.put("Tiếng Kyrgyzstan", "Kyrgyz");
        allLanguageSupported.put("Tiếng Lithuania", "Lithuanian");
        allLanguageSupported.put("Tiếng Latvia", "Latvian");
        allLanguageSupported.put("Tiếng Maori", "Maori");
        allLanguageSupported.put("Tiếng Macedonia", "Macedonian");
        allLanguageSupported.put("Tiếng Mông Cổ", "Mongolian");
        allLanguageSupported.put("Tiếng Marathi", "Marathi");
        allLanguageSupported.put("Tiếng Mã Lai", "Malay");
        allLanguageSupported.put("Tiếng Maltese", "Maltese");
        allLanguageSupported.put("Tiếng Hà Lan", "Dutch");
        allLanguageSupported.put("Tiếng Na Uy", "Norwegian");
        allLanguageSupported.put("Tiếng Sotho", "Sotho");
        allLanguageSupported.put("Tiếng Punjabi", "Punjabi");
        allLanguageSupported.put("Tiếng Ba Lan", "Polish");
        allLanguageSupported.put("Tiếng Pashto", "Pashto");
        allLanguageSupported.put("Tiếng Bồ Đào Nha", "Portuguese");
        allLanguageSupported.put("Tiếng Quechua", "Quechua");
        allLanguageSupported.put("Tiếng Rumani", "Romanian");
        allLanguageSupported.put("Tiếng Nga", "Russian");
        allLanguageSupported.put("Tiếng Phạn", "Sanskrit");
        allLanguageSupported.put("Tiếng Sami", "Sami");
        allLanguageSupported.put("Tiếng Slovak", "Slovak");
        allLanguageSupported.put("Tiếng Slovenia", "Slovenian");
        allLanguageSupported.put("Tiếng Albania", "Albanian");
        allLanguageSupported.put("Tiếng Serbia", "Serbian");
        allLanguageSupported.put("Tiếng Thụy Điển", "Swedish");
        allLanguageSupported.put("Tiếng Swahili", "Swahili");
        allLanguageSupported.put("Tiếng Syriac", "Syriac");
        allLanguageSupported.put("Tiếng Tamil", "Tamil");
        allLanguageSupported.put("Tiếng Telugu", "Telugu");
        allLanguageSupported.put("Tiếng Thái", "Thai");
        allLanguageSupported.put("Tiếng Tagalog", "Tagalog");
        allLanguageSupported.put("Tiếng Tswana", "Tswana");
        allLanguageSupported.put("Tiếng Thổ Nhĩ Kỳ", "Turkish");
        allLanguageSupported.put("Tiếng Tatar", "Tatar");
        allLanguageSupported.put("Tiếng Tsonga", "Tsonga");
        allLanguageSupported.put("Tiếng Ukraina", "Ukrainian");
        allLanguageSupported.put("Tiếng Urdu", "Urdu");
        allLanguageSupported.put("Tiếng Uzbek", "Uzbek");
        allLanguageSupported.put("Tiếng Việt", "Vietnamese");
        allLanguageSupported.put("Tiếng Xhosa", "Xhosa");
        allLanguageSupported.put("Tiếng Trung Quốc", "Chinese");
        allLanguageSupported.put("Tiếng Hồng Kông", "HongKong");
        allLanguageSupported.put("Tiếng Đài Loan", "Taiwan");
        allLanguageSupported.put("Tiếng Zulu", "Zulu");
    }

    public static Set<String> getLanguagesInVietnamese() {
    	loadLanguages();
        return allLanguageSupported.keySet();
    }
    public static String languageInVietnamese(String code) {
    	loadLanguages();
    	String languageInEnglish = languageOf(code);
    	Set<String> listLanguageInVietname = getLanguagesInVietnamese();
    	for (String lang : listLanguageInVietname) {
    		if (allLanguageSupported.get(lang).equalsIgnoreCase(languageInEnglish)) {
    			return lang;
    		}
    	}
    	return null;
    }
    
    public static ArrayList<String> list = null;
    
    public static ArrayList<String> listLanguageInVietnamese() {
    	list = new ArrayList<>();
    	list.add("Tiếng Anh");
    	list.add("Tiếng Armenia");
    	list.add("Tiếng Albania");
    	list.add("Tiếng Ả Rập");
    	list.add("Tiếng Afrikaans");
    	list.add("Tiếng Belarus");
    	list.add("Tiếng Bungari");
    	list.add("Tiếng Bosnia");
    	list.add("Tiếng Ba Lan");
    	list.add("Tiếng Bồ Đào Nha");
    	list.add("Tiếng Catala");
    	list.add("Tiếng Croatia");
    	list.add("Tiếng Divehi");
    	list.add("Tiếng Do Thái");
    	list.add("Tiếng Đài Loan");
    	list.add("Tiếng Đan Mạch");
    	list.add("Tiếng Đức");
    	list.add("Tiếng Esperanto");
    	list.add("Tiếng Estonia");
    	list.add("Tiếng Farsi");
    	list.add("Tiếng Faroese");
    	list.add("Tiếng Galicia");
    	list.add("Tiếng Gujarati");
    	list.add("Tiếng Gruzia");
    	list.add("Tiếng Hindi");
    	list.add("Tiếng Hàn Quốc");
    	list.add("Tiếng Hà Lan");
    	list.add("Tiếng Hy Lạp");
    	list.add("Tiếng Hungary");
    	list.add("Tiếng Hồng Kông");
    	list.add("Tiếng Indonesia");
    	list.add("Tiếng Icelandic");
    	list.add("Tiếng Kazakh");
    	list.add("Tiếng Kannada");
    	list.add("Tiếng Konkani");
    	list.add("Tiếng Kyrgyzstan");
    	list.add("Tiếng Lithuania");
    	list.add("Tiếng Latvia");
    	list.add("Tiếng Maori");
    	list.add("Tiếng Macedonia");
    	list.add("Tiếng Mông Cổ");
    	list.add("Tiếng Marathi");
    	list.add("Tiếng Mã Lai");
    	list.add("Tiếng Maltese");
    	list.add("Tiếng Na Uy");
    	list.add("Tiếng Nhật");
    	list.add("Tiếng Nga");
    	list.add("Tiếng Phần Lan");
    	list.add("Tiếng Pháp");
    	list.add("Tiếng Pashto");
    	list.add("Tiếng Punjabi");
    	list.add("Tiếng Phạn");
    	list.add("Tiếng Quechua");
    	list.add("Tiếng Rumani");
    	list.add("Tiếng Sami");
    	list.add("Tiếng Slovak");
    	list.add("Tiếng Slovenia");
    	list.add("Tiếng Serbia");
    	list.add("Tiếng Swahili");
    	list.add("Tiếng Syriac");
    	list.add("Tiếng Séc");
    	list.add("Tiếng Sotho");
    	list.add("Tiếng Tamil");
    	list.add("Tiếng Telugu");
    	list.add("Tiếng Thái");
    	list.add("Tiếng Tagalog");
    	list.add("Tiếng Tswana");
    	list.add("Tiếng Thổ Nhĩ Kỳ");
    	list.add("Tiếng Tatar");
    	list.add("Tiếng Tsonga");
    	list.add("Tiếng Trung Quốc");
    	list.add("Tiếng Thụy Điển");
    	list.add("Tiếng Tây Ban Nha");
    	list.add("Tiếng Ukraina");
    	list.add("Tiếng Urdu");
    	list.add("Tiếng Uzbek");
    	list.add("Tiếng Việt");
    	list.add("Tiếng Xứ Wales");
    	list.add("Tiếng Xứ Basque");
    	list.add("Tiếng Xhosa");
    	list.add("Tiếng Ý");
    	list.add("Tiếng Zulu");
    	return list;
    	
    }
    public static String getCodeOfLanguageInVietnamese(String language) {
        return codeOf(allLanguageSupported.get(language));
    }
    
}
