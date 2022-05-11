package domain

import domain.criterios.Basico
import domain.criterios.CriterioDeAprovacao
import domain.criterios.Intermediario
import domain.criterios.Rigoroso
import domain.Boletim
import domain.BoletimFechado

class AnalisadorDeAprovacao {
    private lateinit var criterio: CriterioDeAprovacao

    fun defineCriterio(criterio : CriterioDeAprovacao) {
        this.criterio = criterio
    }

    fun fechaBoletim(boletim : Boletim): BoletimFechado{
        var boletimF: BoletimFechado = BoletimFechado(boletim.mediaEPs, boletim.mediaMiniEPs,
            criterio.mediaFinal(boletim), criterio.estaAprovado(boletim))
        return boletimF
    }
}