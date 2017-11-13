package io.pavelshackih.yandextranslator

import android.support.test.filters.SmallTest
import android.support.test.runner.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.standalone.StandAloneContext

@SmallTest
@RunWith(AndroidJUnit4::class)
class KoinInjectionTest {

    @Test
    fun koinDryRunTest() {
        StandAloneContext.koinContext.dryRun()
    }
}