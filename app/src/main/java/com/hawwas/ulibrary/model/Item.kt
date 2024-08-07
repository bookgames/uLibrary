package com.hawwas.ulibrary.model

data class Item(
    val name: String,
    val author: String,
    val category: String,
    var version: String,
    val remotePath: String,
    val subjectName: String,
) {
    var starred: Boolean = false
    var lastWatched: Long = 0
    var downloaded: DownloadStatus = DownloadStatus.NOT_STARTED

    fun getCategoryDir(): String {
        return when (category) {
            "sections" -> "sections/"
            else -> "$category/"
        }
    }

    /**
     * @return the path from subjects directory including the subject name
     */
    fun getPathFromSubjects(): String {
        return subjectName + "/" + getCategoryDir() + name
    }

}

enum class DownloadStatus {
    NOT_STARTED,
    DOWNLOADING,
    DOWNLOADED,
    LOCAL,
    FAILED
}
