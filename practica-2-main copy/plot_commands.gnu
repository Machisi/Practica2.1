set datafile separator ","

f(x) = a*x + b
g(x) = c*x + d

fit f(x) "output.csv" using 1:3 via a, b
fit g(x) "output.csv" using 1:4 via c, d

set xlabel "Talla"
set ylabel "Tiempo (nanosegundos)"

plot "output.csv" using 1:2 title "Mejor caso" with linespoints lc rgb "violet", \
     "output.csv" using 1:3 title "Peor caso" with linespoints lc rgb "green", \
     "output.csv" using 1:4 title "Promedio" with linespoints lc rgb "blue", \
     f(x) title "Ajuste peor caso" with lines lc rgb "dark-green", \
     g(x) title "Ajuste promedio" with lines lc rgb "dark-blue"
