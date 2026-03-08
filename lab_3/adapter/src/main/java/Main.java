public class Main {
    public static void main(String[] args) {
        RoundHole hole = new RoundHole(5);
        RoundPeg roundPeg = new RoundPeg(5);
        hole.fits(roundPeg);

        SquarePeg smallSquarePeg = new SquarePeg(5);
        SquarePeg largeSquarePeg = new SquarePeg(10);
//        hole.fits(smallSquarePeg); // this won't compile (incompatible types)

        SquarePegAdapter smallSquareAdapter = new SquarePegAdapter(smallSquarePeg);
        SquarePegAdapter largeSquareAdapter = new SquarePegAdapter(largeSquarePeg);

        System.out.println("hole >= small adapter: " + hole.fits(smallSquareAdapter) + " " + hole.getRadius() + " - " + smallSquareAdapter.getRadius());
        System.out.println("hole >= small adapter: " + hole.fits(largeSquareAdapter) + " " + hole.getRadius() + " - " + largeSquareAdapter.getRadius());
    }
}
