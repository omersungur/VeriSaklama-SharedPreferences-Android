sharedPreferences = this.getSharedPreferences("com.omersungur.verisaklama_sharedpreferences_android",MODE_PRIVATE) --- sharedPreferences tanımlaması.

sharedPreferences.edit().putInt("storedAge",userAge).apply() --- veriyi sakladık.

var storedAge = sharedPreferences.getInt("storedAge",0) --- saklanan veriyi aldık.
