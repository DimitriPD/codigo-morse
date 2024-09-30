public class CodigoMorse {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        System.out.println(arvore.decodeMorse("-... .- -. .- -. .-"));
        System.out.println(arvore.encodeMorse("banana"));
    }
}