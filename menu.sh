#!/bin/bash
# CSE237 EasyMeal Project

cd src/ || return
clear
javac menu/MenuItem.java cart/UserCart.java main/RunMenu.java
java main/RunMenu