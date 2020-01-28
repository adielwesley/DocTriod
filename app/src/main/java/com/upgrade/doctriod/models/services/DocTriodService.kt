package com.upgrade.doctriod.models.services;

import com.upgrade.doctriod.models.Doctor
import io.reactivex.Observable

import retrofit2.http.GET

public interface DocTriodService {

    @GET("doctor")
    fun getDoctors() : Observable<List<Doctor>>
}
