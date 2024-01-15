import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.desc.Resource
import dev.icerock.moko.resources.desc.StringDesc
import dev.icerock.moko.resources.desc.desc
import dev.icerock.moko.resources.format

fun getStrings(idString: StringResource): StringDesc {
    return idString.desc()
}

fun getStrings(idString: StringResource, vararg args: Any): StringDesc {
    return idString.format(*args)
}