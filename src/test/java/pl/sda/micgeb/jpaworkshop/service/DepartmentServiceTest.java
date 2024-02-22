package pl.sda.micgeb.jpaworkshop.service;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import pl.sda.micgeb.jpaworkshop.model.Address;
import pl.sda.micgeb.jpaworkshop.model.entity.Department;
import pl.sda.micgeb.jpaworkshop.repository.DepartmentRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
//@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

    private DepartmentService departmentService;
    private DepartmentRepository departmentRepository;

    static long start;
    static long finish;

    @BeforeAll
    static void beforeAll() {
        start = System.nanoTime();
    }

    @AfterAll
    static void afterAll() {
        finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.printf("Czas wykonania: [%s] sekund", (double) timeElapsed / 1_000_000_000);
    }

    @BeforeEach
    void setUp() {
//        departmentRepository = new InMemoryDepartmentRepository();
        departmentRepository = mock(DepartmentRepository.class);
        departmentService = new DepartmentService(departmentRepository, new DepartmentMapper());
    }

    @Test
    void findDepartmentByName() {
        //given
        String departmentName = "IT";
        var department = new Department();
        department.setName(departmentName);
        department.setAddress(new Address(
                "Anglia", "Londyn", "Buckingham Street", "01011"));

        when(departmentRepository.findByName(Mockito.anyString()))
                .thenReturn(Optional.of(department));

        //when
        Department departmentByName = departmentService.findDepartmentByName(departmentName);

        //then
        assertEquals(departmentName, departmentByName.getName());
        assertEquals("Anglia", departmentByName.getAddress().getCountry());
    }

    @Test
    void findAllByName() {
    }

    @Test
    void addNewDepartment() {
    }

    @Test
    void findDepartmentsByCity() {
    }

    @Test
    void deleteDepartmentByName() {
    }
}