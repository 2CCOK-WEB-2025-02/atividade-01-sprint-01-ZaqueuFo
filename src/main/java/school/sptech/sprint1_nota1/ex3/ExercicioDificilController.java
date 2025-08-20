package school.sptech.sprint1_nota1.ex3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ExercicioDificilController {
    @GetMapping("/ex-03/{n}")
    public ExercicioDificilResponse exercicioDificil(@PathVariable int n) {
        ExercicioDificilResponse resposta = new ExercicioDificilResponse();
        List<Integer> minhaLista = new ArrayList<>();
        int soma = 1;
        minhaLista.add(0);
        minhaLista.add(1);

        if (n <= 0) {
            resposta.setSoma(0);
            resposta.setEnesimoTermo(0);
            return resposta;
        }

        if (n == 1) {
            resposta.setSoma(1);
            resposta.setEnesimoTermo(1);
            return resposta;
        }

        for (int i = 2; i <= n; i++) {
            int proximoValor = minhaLista.get(i-1) + minhaLista.get(i-2);
            minhaLista.add(proximoValor);
            soma += proximoValor;
        }

        resposta.setSoma(soma);
        resposta.setEnesimoTermo(minhaLista.get(minhaLista.size() - 1));
        return resposta;
    }
}
