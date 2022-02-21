package com.remya.communityfordevelopers.models

class ItemModel {
    var image: String? = null
        private set
    var nama: String? = null
        private set
    var usia: String? = null
        private set
    var kota: String? = null
        private set

    constructor() {}
    constructor(image: String, nama: String?, usia: String?, kota: String?) {
        this.image = image
        this.nama = nama
        this.usia = usia
        this.kota = kota
    }
}