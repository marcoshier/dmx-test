
import org.openrndr.application
import org.openrndr.extra.olive.oliveProgram
import org.openrndr.opendmx.Native

fun main() = application {
    configure {
        width = 768
        height = 576
    }

    Native.connect(1)

    oliveProgram {

        val ba = ByteArray(512) { 1.toByte() }

        extend {
            println((mouse.position.x / width) * 255)
            (0..511).map {
                ba[it] = ((mouse.position.x / width) * 255).toInt().toByte()
            }
            Native.send(ba)
            Thread.sleep(30)
            //     ba[1] = 244.toByte()

        }
    }
}
