import com.indvd00m.ascii.render.Region
import com.indvd00m.ascii.render.Render
import com.indvd00m.ascii.render.elements.Rectangle
import com.indvd00m.ascii.render.elements.plot.Axis
import com.indvd00m.ascii.render.elements.plot.AxisLabels
import com.indvd00m.ascii.render.elements.plot.Plot
import com.indvd00m.ascii.render.elements.plot.api.IPlotPoint
import com.indvd00m.ascii.render.elements.plot.misc.PlotPoint
import java.util.ArrayList


/*************************************************************
 * ESTA CLASSE É FORNECIDA PARA APOIO AOS TRABALHOS DE FÍSICA
 * NÃO ALTERAR
 *************************************************************
 */

// based on https://github.com/indvd00m/java-ascii-render
class Chart(val width: Int, val height: Int) {

    var points = ArrayList<IPlotPoint>()

    fun ponto(x: Double, y: Double) {
        points.add(PlotPoint(x,y))
    }

    fun reset() {
        points.clear()
    }

    fun draw() {
        val render = Render()
        val builder = render.newBuilder()
        builder.width(width).height(height)
        builder.element(Rectangle(0, 0, width, height))
        builder.layer(Region(1, 1, width - 2, height - 2))
        builder.element(Axis(points, Region(0, 0, width - 2, height - 2)))
        builder.element(AxisLabels(points, Region(0, 0, width - 2, height - 2)))
        builder.element(Plot(points, Region(0, 0, width - 2, height - 2)))
        val canvas = render.render(builder.build())
        val s = canvas.text
        println(s)

        reset()
    }

}