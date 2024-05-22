package com.hawwas.ulibrary.domain.repo

import com.hawwas.ulibrary.model.*

interface LocalStorage {

    companion object {
        const val subjectFile = "subject.json"
        const val rootDir = "data/"
        const val HeadersAbs = rootDir + "subjectsInfo.json"
        const val subjectsHeaderFile = "subjectsInfo.json"
        const val subjectsDir = "subjects/"

        fun getItemPath(item: Item): String {
            return rootDir + subjectsDir + item.getPathFromSubjects()
        }

        fun getSubjectFile(subject: Subject): String {
            return rootDir + subjectsDir + subject.name + "/" + subjectFile
        }

    }

    fun loadLocalSubjects(): List<Subject>
    fun saveFile(folderName: String, fileName: String, data: ByteArray)
    fun saveFile( fileName: String, data: ByteArray)
    fun saveCache(folderName: String, fileName: String, data: ByteArray)
    fun getFileContent(path: String): String?

    suspend fun saveLastFetchedTime(time: Long)
    suspend fun getLastFetchedTime(): Long
    fun saveSubjectData(subject: Subject)
    fun updateDownloaded(item: Item)


}