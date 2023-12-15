package game.components;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Path {
    private List<PathBox> pathBoxes = new ArrayList<>();

    public List<PathBox> getPathBoxes() {
        return pathBoxes;
    }

    public void setPathBoxes(List<PathBox> pathBoxes) {
        this.pathBoxes = pathBoxes;
    }

    public boolean haveMonster(Long playerId) {
        return pathBoxes.stream().anyMatch( pathBox -> pathBox.getMonster() != null && pathBox.getMonster().getPlayer().getId().equals(playerId) );
    }

    public void nextRound(Long playerId, Castle castle) {
        Optional<PathBox> occupiedPathBox = pathBoxes.stream().filter(pathBox -> pathBox.getMonster() != null && pathBox.getMonster().getPlayer().getId().equals(playerId)).findFirst();
        //buscamos la casilla ocupada por el monstruo
        if(occupiedPathBox.isPresent()) {
            //si es el player 1 (azul)
            if(playerId.equals(1L)) {
                //si la casilla de arriba es el castillo
                if(occupiedPathBox.get().getNorthBox() == null) {
                    //decrementamos la vida solo si es mayor a 0
                    if (castle.getLife() > 0){
                        castle.setLife(castle.getLife() - 1);
                    }
                    occupiedPathBox.get().setMonster(null);
                } else {
                    if(occupiedPathBox.get().getNorthBox().getMonster() == null) {
                        occupiedPathBox.get().getMonster().move(occupiedPathBox.get(), occupiedPathBox.get().getNorthBox());
                    } else {
                        //si la casilla esta ocupada, y el monstruo es enemigo
                        System.out.println("Casilla " + occupiedPathBox.get().getNorthBox().getName() + " Esta ocupada!!!");
                        System.out.println("Monstruo " + occupiedPathBox.get().getMonster() + " Ataca a " + occupiedPathBox.get().getNorthBox().getMonster());
                        occupiedPathBox.get().getMonster().attack(occupiedPathBox.get().getNorthBox().getMonster());
                        occupiedPathBox.get().getNorthBox().getMonster().attack(occupiedPathBox.get().getMonster());
                        //si el monstruo enemigo muere
                        if(occupiedPathBox.get().getNorthBox().getMonster().getLife() <= 0) {
                            occupiedPathBox.get().getNorthBox().setMonster(null);
                        }
                    }
                }
            //si es el player 2 (rojo)
            } else {
                //si la casilla de abajo es el castillo
                if(occupiedPathBox.get().getSouthBox() == null ) {
                    if (castle.getLife() > 0){
                        castle.setLife(castle.getLife() - 1);
                    }
                    occupiedPathBox.get().setMonster(null);
                } else {
                    //si la casilla de abajo esta vacia, mover
                    if (occupiedPathBox.get().getSouthBox().getMonster() == null) {
                        occupiedPathBox.get().getMonster().move(occupiedPathBox.get(), occupiedPathBox.get().getSouthBox());
                    } else {
                    //si la casilla de abajo esta ocupada, y el monstruo es enemigo
                        System.out.println("Casilla " + occupiedPathBox.get().getSouthBox().getName() + " Esta ocupada!!!");
                        System.out.println("Monstruo " + occupiedPathBox.get().getMonster() + " Ataca a " + occupiedPathBox.get().getSouthBox().getMonster());
                        occupiedPathBox.get().getMonster().attack(occupiedPathBox.get().getSouthBox().getMonster());
                        occupiedPathBox.get().getSouthBox().getMonster().attack(occupiedPathBox.get().getMonster());
                        if (occupiedPathBox.get().getSouthBox().getMonster().getLife() <= 0) {
                            occupiedPathBox.get().getSouthBox().setMonster(null);
                        }
                    }
                }
            }
        }
    }

    //se updatean las casillas DE LOS MONSTRUOS
    public void update() {
        this.pathBoxes.forEach(PathBox::update);
    }

    public void releaseMonster(Long playerId, Monster monster) {
        if(playerId.equals(1L)) {
            if(pathBoxes.get(2).getMonster() == null) {
                pathBoxes.get(2).setMonster(monster);
            }
        } else {
            if(pathBoxes.get(0).getMonster() == null) {
                pathBoxes.get(0).setMonster(monster);
            }
        }
    }
}
