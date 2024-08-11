package com.alisdn.samplemvvmandroid.domain

import com.alisdn.samplemvvmandroid.data.BreedResponse
import com.alisdn.samplemvvmandroid.data.CatResponse
import com.alisdn.samplemvvmandroid.data.WeightResponse


data class Cat(
    val breeds: List<Breed>?,
    val id: String,
    val url: String,
    val width: Int,
    val height: Int
)

data class Breed(
    val weight: Weight?,
    val id: String,
    val name: String,
    val vetstreet_url: String?,
    val temperament: String?,
    val origin: String?,
    val country_codes: String?,
    val country_code: String?,
    val description: String?,
    val life_span: String?,
    val indoor: Int?,
    val lap: Int?,
    val alt_names: String?,
    val adaptability: Int?,
    val affection_level: Int?,
    val child_friendly: Int?,
    val dog_friendly: Int?,
    val energy_level: Int?,
    val grooming: Int?,
    val health_issues: Int?,
    val intelligence: Int?,
    val shedding_level: Int?,
    val social_needs: Int?,
    val stranger_friendly: Int?,
    val vocalisation: Int?,
    val experimental: Int?,
    val hairless: Int?,
    val natural: Int?,
    val rare: Int?,
    val rex: Int?,
    val suppressed_tail: Int?,
    val short_legs: Int?,
    val wikipedia_url: String?,
    val hypoallergenic: Int?,
    val reference_image_id: String?
)

data class Weight(
    val imperial: String,
    val metric: String
)



fun BreedResponse.toBreed(): Breed {
    return Breed(
        weight = weight?.toWeight(),
        id = id,
        name = name,
        vetstreet_url = vetstreet_url,
        temperament = temperament,
        origin = origin,
        country_codes = country_codes,
        country_code = country_code,
        description = description,
        life_span = life_span,
        indoor = indoor,
        lap = lap,
        alt_names = alt_names,
        adaptability = adaptability,
        affection_level = affection_level,
        child_friendly = child_friendly,
        dog_friendly = dog_friendly,
        energy_level = energy_level,
        grooming = grooming,
        health_issues = health_issues,
        intelligence = intelligence,
        shedding_level = shedding_level,
        social_needs = social_needs,
        stranger_friendly = stranger_friendly,
        vocalisation = vocalisation,
        experimental = experimental,
        hairless = hairless,
        natural = natural,
        rare = rare,
        rex = rex,
        suppressed_tail = suppressed_tail,
        short_legs = short_legs,
        wikipedia_url = wikipedia_url,
        hypoallergenic = hypoallergenic,
        reference_image_id = reference_image_id)
}


fun WeightResponse.toWeight(): Weight {
    return Weight(
        imperial = imperial,
        metric = metric
    )
}

fun CatResponse.toCat(): Cat {
    return Cat(
        breeds = breeds?.map { it.toBreed() },
        id = id,
        url = url,
        width = width,
        height = height
    )
}