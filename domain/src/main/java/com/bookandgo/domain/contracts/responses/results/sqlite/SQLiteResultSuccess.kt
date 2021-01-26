package com.bookandgo.domain.contracts.responses.results.sqlite

import com.bookandgo.domain.contracts.responses.results.IResultSuccess
import java.util.*

open class SQLiteResultSuccess<DataType:Any>(override val data:DataType, override val date: Date): IResultSuccess<DataType>