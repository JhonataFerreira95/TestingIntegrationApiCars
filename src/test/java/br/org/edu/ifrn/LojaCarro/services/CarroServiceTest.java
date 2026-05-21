package br.org.edu.ifrn.LojaCarro.services;

import br.org.edu.ifrn.LojaCarro.model.Carro;
import br.org.edu.ifrn.LojaCarro.repository.CarroRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CarroServiceTest {

    @Mock
    private CarroRepository carroRepository;

    @InjectMocks
    private CarroService carroService;

    @Test
    void saveDeveDelegarParaRepositoryERetornarCarroSalvo() {
        Carro carro = criarCarro(1L, "Gol", 2020);

        when(carroRepository.save(carro)).thenReturn(carro);

        Carro resultado = carroService.save(carro);

        assertSame(carro, resultado);
        verify(carroRepository).save(carro);
        verifyNoMoreInteractions(carroRepository);
    }

    @Test
    void updateDeveDelegarParaRepositoryERetornarCarroAtualizado() {
        Carro carro = criarCarro(2L, "Onix", 2022);

        // mock do existsById que adicionamos no CarroService
        when(carroRepository.existsById(carro.getId())).thenReturn(true);
        when(carroRepository.save(carro)).thenReturn(carro);

        Carro resultado = carroService.update(carro);

        assertSame(carro, resultado);
        verify(carroRepository).existsById(carro.getId());
        verify(carroRepository).save(carro);
        verifyNoMoreInteractions(carroRepository);
    }

    @Test
    void updateDevelancarExcecaoQuandoIdNaoExiste() {
        Carro carro = criarCarro(99L, "Inexistente", 2020);

        when(carroRepository.existsById(carro.getId())).thenReturn(false);

        assertThrows(RuntimeException.class, () -> carroService.update(carro));

        verify(carroRepository).existsById(carro.getId());
        verifyNoMoreInteractions(carroRepository);
    }

    @Test
    void deleteByIdDeveDelegarParaRepositoryComIdInformado() {
        Long id = 10L;

        carroService.deleteById(id);

        verify(carroRepository, times(1)).deleteById(id);
        verifyNoMoreInteractions(carroRepository);
    }

    @Test
    void findByIdDeveRetornarCarroQuandoEncontrado() {
        Long id = 3L;
        Carro carro = criarCarro(id, "HB20", 2021);

        when(carroRepository.findById(id)).thenReturn(Optional.of(carro));

        Optional<Carro> resultado = carroService.findById(id);

        assertTrue(resultado.isPresent());
        assertSame(carro, resultado.get());
        verify(carroRepository).findById(id);
        verifyNoMoreInteractions(carroRepository);
    }

    @Test
    void findByIdDeveRetornarOptionalVazioQuandoNaoEncontrado() {
        Long id = 99L;

        when(carroRepository.findById(id)).thenReturn(Optional.empty());

        Optional<Carro> resultado = carroService.findById(id);

        assertTrue(resultado.isEmpty());
        verify(carroRepository).findById(id);
        verifyNoMoreInteractions(carroRepository);
    }

    @Test
    void findAllDeveRetornarListaDeCarrosDoRepository() {
        List<Carro> carros = List.of(
                criarCarro(1L, "Gol", 2020),
                criarCarro(2L, "Onix", 2022)
        );

        when(carroRepository.findAll()).thenReturn(carros);

        List<Carro> resultado = carroService.findAll();

        assertEquals(2, resultado.size());
        assertSame(carros, resultado);
        verify(carroRepository).findAll();
        verifyNoMoreInteractions(carroRepository);
    }

    private Carro criarCarro(Long id, String modelo, int ano) {
        Carro carro = new Carro();
        carro.setId(id);
        carro.setModelo(modelo);
        carro.setAno(ano);
        return carro;
    }
}