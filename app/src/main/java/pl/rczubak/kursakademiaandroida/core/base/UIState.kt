package pl.rczubak.kursakademiaandroida.core.base

sealed class UIState {
    object Idle: UIState()
    object Pending: UIState()
}