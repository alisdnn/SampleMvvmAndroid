import com.alisdn.samplemvvmandroid.data.ApiService
import com.alisdn.samplemvvmandroid.data.CatResponse
import com.alisdn.samplemvvmandroid.domain.CatRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

@OptIn(ExperimentalCoroutinesApi::class)
class CatRepositoryTest {

    @Mock
    private lateinit var apiService: ApiService

    private lateinit var repository: CatRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        repository = CatRepository(apiService)
    }

    @Test
    fun getCats_SuccessfulFetch_ReturnsCats() = runBlocking {
        // Arrange
        val fakeCats = listOf(
            CatResponse("1", "url1", 200, 200),
            CatResponse("2", "url2", 400, 400)
        )
        `when`(apiService.getCats(50, 0)).thenReturn(fakeCats)

        // Act
        val result = repository.getCats(50, 0)

        // Assert
        assertEquals(2, result.size)
        assertEquals("1", result[0].id)
    }

    @Test(expected = Exception::class)
    fun getCats_ApiThrowsError_ThrowsException(): Unit = runBlocking {
        // Arrange
        `when`(apiService.getCats(50, 0)).thenThrow(RuntimeException("Network Error"))

        // Act
        repository.getCats(50, 0)
    }
}
