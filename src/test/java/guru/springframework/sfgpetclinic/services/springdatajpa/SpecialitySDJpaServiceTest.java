package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.SpecialtyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SpecialitySDJpaServiceTest {
    @Mock
    private SpecialtyRepository specialtyRepository;

    @InjectMocks
    private SpecialitySDJpaService service;

    @Test
    void testDeleteById() {
        service.deleteById(1L);
        service.deleteById(1L);

        verify(specialtyRepository, times(2)).deleteById(1L);
        verify(specialtyRepository, atLeastOnce()).deleteById(1L);
        verify(specialtyRepository, atMost(2)).deleteById(1L);
        verify(specialtyRepository, never()).deleteById(5L);
    }
    
    @Test
    void testDelete() {
        service.delete(new Speciality());
    }
}