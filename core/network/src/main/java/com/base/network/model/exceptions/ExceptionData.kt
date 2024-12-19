package com.base.network.model.exceptions

data class ExceptionData(
    val message: String?,
    val code: Int? = null,
    val validationErrorMessages: List<CommonValidationError>? = null
) {
    fun getRealErrorMessage(): String {
        return this.validationErrorMessages?.joinToString { validationErrors ->
            validationErrors.message.orEmpty()
        } ?: this.message.orEmpty()
    }

}
