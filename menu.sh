#!/bin/bash
# CSE237 EasyMeal Project

cd src/ || return
javac menu/MenuItem.java cart/UserCart.java tip/TipFunction main/MainMethod.java
java main/MainMethod