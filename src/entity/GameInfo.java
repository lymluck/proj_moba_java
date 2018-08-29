package entity;

import java.util.List;

public class GameInfo {
    /**
     * type : update
     * myCamp : blue
     * state : {"time":180040,"camps":{"blue":{"towerCount":0,"goldCount":0,"killCount":0},"red":{"towerCount":6,"goldCount":1118,"killCount":89}},"towers":[{"id":0,"type":"tower","position":{"x":2176,"y":1344},"goldPerSecond":2,"aura":"speed","camp":"red","healthPoint":500,"initHealthPoint":500},{"id":1,"type":"tower","position":{"x":1248,"y":2176},"goldPerSecond":1,"aura":"","camp":"red","healthPoint":350,"initHealthPoint":350},{"id":2,"type":"tower","position":{"x":1216,"y":1408},"goldPerSecond":1,"aura":"physics","camp":"red","healthPoint":350,"initHealthPoint":350},{"id":3,"type":"tower","position":{"x":3008,"y":2176},"goldPerSecond":1,"aura":"","camp":"red","healthPoint":350,"initHealthPoint":350},{"id":4,"type":"tower","position":{"x":3168,"y":1280},"goldPerSecond":1,"aura":"physics","camp":"red","healthPoint":350,"initHealthPoint":350},{"id":5,"type":"tower","position":{"x":2240,"y":224},"goldPerSecond":1,"aura":"magic","camp":"red","healthPoint":350,"initHealthPoint":350}],"heros":[{"id":0,"type":"hero","camp":"blue","name":"shooter","moveSpeed":200,"attackDamageMin":45,"attackDamageMax":55,"attackRange":220,"attackAnimation":120,"attackGap":1300,"attackMissileSpeed":300,"fireName":"damage","fireDamage":300,"fireDuration":0,"fireRange":450,"fireAnimation":200,"fireGap":10000,"fireMissileSpeed":400,"position":{"x":464,"y":1648},"orientation":"bottom","status":"stop","cmd":{},"executingCmd":{},"healthPoint":562.6999999999999,"attackCD":0,"fireCD":0,"dazingRemaining":0,"rebornRemaining":0,"initHealthPoint":650},{"id":1,"type":"hero","camp":"blue","name":"shooter","moveSpeed":200,"attackDamageMin":45,"attackDamageMax":55,"attackRange":220,"attackAnimation":120,"attackGap":1300,"attackMissileSpeed":300,"fireName":"damage","fireDamage":300,"fireDuration":0,"fireRange":450,"fireAnimation":200,"fireGap":10000,"fireMissileSpeed":400,"position":{"x":560,"y":1648},"orientation":"bottom","status":"dead","cmd":{},"executingCmd":{},"healthPoint":0,"attackCD":0,"fireCD":0,"dazingRemaining":0,"rebornRemaining":6320,"initHealthPoint":650},{"id":2,"type":"hero","camp":"blue","name":"shooter","moveSpeed":200,"attackDamageMin":45,"attackDamageMax":55,"attackRange":220,"attackAnimation":120,"attackGap":1300,"attackMissileSpeed":300,"fireName":"damage","fireDamage":300,"fireDuration":0,"fireRange":450,"fireAnimation":200,"fireGap":10000,"fireMissileSpeed":400,"position":{"x":400,"y":1552},"orientation":"bottom","status":"dead","cmd":{},"executingCmd":{},"healthPoint":0,"attackCD":0,"fireCD":0,"dazingRemaining":0,"rebornRemaining":7400,"initHealthPoint":650},{"id":3,"type":"hero","camp":"blue","name":"shooter","moveSpeed":200,"attackDamageMin":45,"attackDamageMax":55,"attackRange":220,"attackAnimation":120,"attackGap":1300,"attackMissileSpeed":300,"fireName":"damage","fireDamage":300,"fireDuration":0,"fireRange":450,"fireAnimation":200,"fireGap":10000,"fireMissileSpeed":400,"position":{"x":496,"y":1552},"orientation":"bottom","status":"dead","cmd":{},"executingCmd":{},"healthPoint":0,"attackCD":0,"fireCD":0,"dazingRemaining":0,"rebornRemaining":14400,"initHealthPoint":650},{"id":4,"type":"hero","camp":"blue","name":"shooter","moveSpeed":200,"attackDamageMin":45,"attackDamageMax":55,"attackRange":220,"attackAnimation":120,"attackGap":1300,"attackMissileSpeed":300,"fireName":"damage","fireDamage":300,"fireDuration":0,"fireRange":450,"fireAnimation":200,"fireGap":10000,"fireMissileSpeed":400,"position":{"x":592,"y":1552},"orientation":"bottom","status":"dead","cmd":{},"executingCmd":{},"healthPoint":0,"attackCD":0,"fireCD":0,"dazingRemaining":0,"rebornRemaining":8800,"initHealthPoint":650},{"id":5,"type":"hero","camp":"red","name":"warrior","moveSpeed":160,"attackDamageMin":70,"attackDamageMax":80,"attackRange":100,"attackAnimation":80,"attackGap":1200,"attackMissileSpeed":0,"fireName":"daze","fireDamage":20,"fireDuration":2000,"fireRange":300,"fireAnimation":200,"fireGap":16000,"fireMissileSpeed":400,"position":{"x":514.26053453407,"y":1600},"orientation":"bottom","status":"stop","cmd":{"id":"6632c3b0-d44e-11e7-b832-efd8446f7f2b","type":"attack","targetType":"hero","targetId":0},"executingCmd":{},"healthPoint":900,"attackCD":440,"fireCD":12480,"dazingRemaining":0,"rebornRemaining":0,"initHealthPoint":900},{"id":6,"type":"hero","camp":"red","name":"warrior","moveSpeed":160,"attackDamageMin":70,"attackDamageMax":80,"attackRange":100,"attackAnimation":80,"attackGap":1200,"attackMissileSpeed":0,"fireName":"daze","fireDamage":20,"fireDuration":2000,"fireRange":300,"fireAnimation":200,"fireGap":16000,"fireMissileSpeed":400,"position":{"x":514.2634830798235,"y":1600},"orientation":"bottom","status":"stop","cmd":{"id":"6632c3b1-d44e-11e7-b832-efd8446f7f2b","type":"attack","targetType":"hero","targetId":0},"executingCmd":{},"healthPoint":900,"attackCD":440,"fireCD":12480,"dazingRemaining":0,"rebornRemaining":0,"initHealthPoint":900},{"id":7,"type":"hero","camp":"red","name":"shooter","moveSpeed":200,"attackDamageMin":45,"attackDamageMax":55,"attackRange":220,"attackAnimation":120,"attackGap":1300,"attackMissileSpeed":300,"fireName":"damage","fireDamage":300,"fireDuration":0,"fireRange":450,"fireAnimation":200,"fireGap":10000,"fireMissileSpeed":400,"position":{"x":571.6445760821151,"y":1662.5525851702894},"orientation":"left","status":"waitingAttack","cmd":{"id":"6632c3b2-d44e-11e7-b832-efd8446f7f2b","type":"attack","targetType":"hero","targetId":0},"executingCmd":{"id":"65b8d8c2-d44e-11e7-b832-efd8446f7f2b","type":"attack","targetType":"hero","targetId":0},"healthPoint":650,"attackCD":500,"fireCD":3200,"dazingRemaining":0,"rebornRemaining":0,"initHealthPoint":650},{"id":8,"type":"hero","camp":"red","name":"warrior","moveSpeed":160,"attackDamageMin":70,"attackDamageMax":80,"attackRange":100,"attackAnimation":80,"attackGap":1200,"attackMissileSpeed":0,"fireName":"daze","fireDamage":20,"fireDuration":2000,"fireRange":300,"fireAnimation":200,"fireGap":16000,"fireMissileSpeed":400,"position":{"x":514.2620234761716,"y":1600},"orientation":"bottom","status":"stop","cmd":{"id":"6632c3b3-d44e-11e7-b832-efd8446f7f2b","type":"attack","targetType":"hero","targetId":0},"executingCmd":{},"healthPoint":900,"attackCD":440,"fireCD":12480,"dazingRemaining":0,"rebornRemaining":0,"initHealthPoint":900},{"id":9,"type":"hero","camp":"red","name":"shooter","moveSpeed":200,"attackDamageMin":45,"attackDamageMax":55,"attackRange":220,"attackAnimation":120,"attackGap":1300,"attackMissileSpeed":300,"fireName":"damage","fireDamage":300,"fireDuration":0,"fireRange":450,"fireAnimation":200,"fireGap":10000,"fireMissileSpeed":400,"position":{"x":571.2463587355398,"y":1662.4312617781986},"orientation":"left","status":"waitingAttack","cmd":{"id":"6632c3b4-d44e-11e7-b832-efd8446f7f2b","type":"attack","targetType":"hero","targetId":0},"executingCmd":{"id":"65b8d8c4-d44e-11e7-b832-efd8446f7f2b","type":"attack","targetType":"hero","targetId":0},"healthPoint":650,"attackCD":500,"fireCD":3200,"dazingRemaining":0,"rebornRemaining":0,"initHealthPoint":650}]}
     */

    private String type;
    private String myCamp;
    private StateEntity state;

    public void setType(String type) {
        this.type = type;
    }

    public void setMyCamp(String myCamp) {
        this.myCamp = myCamp;
    }

    public void setState(StateEntity state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public String getMyCamp() {
        return myCamp;
    }

    public StateEntity getState() {
        return state;
    }

    public static class StateEntity {
        /**
         * time : 180040
         * camps : {"blue":{"towerCount":0,"goldCount":0,"killCount":0},"red":{"towerCount":6,"goldCount":1118,"killCount":89}}
         * towers : [{"id":0,"type":"tower","position":{"x":2176,"y":1344},"goldPerSecond":2,"aura":"speed","camp":"red","healthPoint":500,"initHealthPoint":500},{"id":1,"type":"tower","position":{"x":1248,"y":2176},"goldPerSecond":1,"aura":"","camp":"red","healthPoint":350,"initHealthPoint":350},{"id":2,"type":"tower","position":{"x":1216,"y":1408},"goldPerSecond":1,"aura":"physics","camp":"red","healthPoint":350,"initHealthPoint":350},{"id":3,"type":"tower","position":{"x":3008,"y":2176},"goldPerSecond":1,"aura":"","camp":"red","healthPoint":350,"initHealthPoint":350},{"id":4,"type":"tower","position":{"x":3168,"y":1280},"goldPerSecond":1,"aura":"physics","camp":"red","healthPoint":350,"initHealthPoint":350},{"id":5,"type":"tower","position":{"x":2240,"y":224},"goldPerSecond":1,"aura":"magic","camp":"red","healthPoint":350,"initHealthPoint":350}]
         * heros : [{"id":0,"type":"hero","camp":"blue","name":"shooter","moveSpeed":200,"attackDamageMin":45,"attackDamageMax":55,"attackRange":220,"attackAnimation":120,"attackGap":1300,"attackMissileSpeed":300,"fireName":"damage","fireDamage":300,"fireDuration":0,"fireRange":450,"fireAnimation":200,"fireGap":10000,"fireMissileSpeed":400,"position":{"x":464,"y":1648},"orientation":"bottom","status":"stop","cmd":{},"executingCmd":{},"healthPoint":562.6999999999999,"attackCD":0,"fireCD":0,"dazingRemaining":0,"rebornRemaining":0,"initHealthPoint":650},{"id":1,"type":"hero","camp":"blue","name":"shooter","moveSpeed":200,"attackDamageMin":45,"attackDamageMax":55,"attackRange":220,"attackAnimation":120,"attackGap":1300,"attackMissileSpeed":300,"fireName":"damage","fireDamage":300,"fireDuration":0,"fireRange":450,"fireAnimation":200,"fireGap":10000,"fireMissileSpeed":400,"position":{"x":560,"y":1648},"orientation":"bottom","status":"dead","cmd":{},"executingCmd":{},"healthPoint":0,"attackCD":0,"fireCD":0,"dazingRemaining":0,"rebornRemaining":6320,"initHealthPoint":650},{"id":2,"type":"hero","camp":"blue","name":"shooter","moveSpeed":200,"attackDamageMin":45,"attackDamageMax":55,"attackRange":220,"attackAnimation":120,"attackGap":1300,"attackMissileSpeed":300,"fireName":"damage","fireDamage":300,"fireDuration":0,"fireRange":450,"fireAnimation":200,"fireGap":10000,"fireMissileSpeed":400,"position":{"x":400,"y":1552},"orientation":"bottom","status":"dead","cmd":{},"executingCmd":{},"healthPoint":0,"attackCD":0,"fireCD":0,"dazingRemaining":0,"rebornRemaining":7400,"initHealthPoint":650},{"id":3,"type":"hero","camp":"blue","name":"shooter","moveSpeed":200,"attackDamageMin":45,"attackDamageMax":55,"attackRange":220,"attackAnimation":120,"attackGap":1300,"attackMissileSpeed":300,"fireName":"damage","fireDamage":300,"fireDuration":0,"fireRange":450,"fireAnimation":200,"fireGap":10000,"fireMissileSpeed":400,"position":{"x":496,"y":1552},"orientation":"bottom","status":"dead","cmd":{},"executingCmd":{},"healthPoint":0,"attackCD":0,"fireCD":0,"dazingRemaining":0,"rebornRemaining":14400,"initHealthPoint":650},{"id":4,"type":"hero","camp":"blue","name":"shooter","moveSpeed":200,"attackDamageMin":45,"attackDamageMax":55,"attackRange":220,"attackAnimation":120,"attackGap":1300,"attackMissileSpeed":300,"fireName":"damage","fireDamage":300,"fireDuration":0,"fireRange":450,"fireAnimation":200,"fireGap":10000,"fireMissileSpeed":400,"position":{"x":592,"y":1552},"orientation":"bottom","status":"dead","cmd":{},"executingCmd":{},"healthPoint":0,"attackCD":0,"fireCD":0,"dazingRemaining":0,"rebornRemaining":8800,"initHealthPoint":650},{"id":5,"type":"hero","camp":"red","name":"warrior","moveSpeed":160,"attackDamageMin":70,"attackDamageMax":80,"attackRange":100,"attackAnimation":80,"attackGap":1200,"attackMissileSpeed":0,"fireName":"daze","fireDamage":20,"fireDuration":2000,"fireRange":300,"fireAnimation":200,"fireGap":16000,"fireMissileSpeed":400,"position":{"x":514.26053453407,"y":1600},"orientation":"bottom","status":"stop","cmd":{"id":"6632c3b0-d44e-11e7-b832-efd8446f7f2b","type":"attack","targetType":"hero","targetId":0},"executingCmd":{},"healthPoint":900,"attackCD":440,"fireCD":12480,"dazingRemaining":0,"rebornRemaining":0,"initHealthPoint":900},{"id":6,"type":"hero","camp":"red","name":"warrior","moveSpeed":160,"attackDamageMin":70,"attackDamageMax":80,"attackRange":100,"attackAnimation":80,"attackGap":1200,"attackMissileSpeed":0,"fireName":"daze","fireDamage":20,"fireDuration":2000,"fireRange":300,"fireAnimation":200,"fireGap":16000,"fireMissileSpeed":400,"position":{"x":514.2634830798235,"y":1600},"orientation":"bottom","status":"stop","cmd":{"id":"6632c3b1-d44e-11e7-b832-efd8446f7f2b","type":"attack","targetType":"hero","targetId":0},"executingCmd":{},"healthPoint":900,"attackCD":440,"fireCD":12480,"dazingRemaining":0,"rebornRemaining":0,"initHealthPoint":900},{"id":7,"type":"hero","camp":"red","name":"shooter","moveSpeed":200,"attackDamageMin":45,"attackDamageMax":55,"attackRange":220,"attackAnimation":120,"attackGap":1300,"attackMissileSpeed":300,"fireName":"damage","fireDamage":300,"fireDuration":0,"fireRange":450,"fireAnimation":200,"fireGap":10000,"fireMissileSpeed":400,"position":{"x":571.6445760821151,"y":1662.5525851702894},"orientation":"left","status":"waitingAttack","cmd":{"id":"6632c3b2-d44e-11e7-b832-efd8446f7f2b","type":"attack","targetType":"hero","targetId":0},"executingCmd":{"id":"65b8d8c2-d44e-11e7-b832-efd8446f7f2b","type":"attack","targetType":"hero","targetId":0},"healthPoint":650,"attackCD":500,"fireCD":3200,"dazingRemaining":0,"rebornRemaining":0,"initHealthPoint":650},{"id":8,"type":"hero","camp":"red","name":"warrior","moveSpeed":160,"attackDamageMin":70,"attackDamageMax":80,"attackRange":100,"attackAnimation":80,"attackGap":1200,"attackMissileSpeed":0,"fireName":"daze","fireDamage":20,"fireDuration":2000,"fireRange":300,"fireAnimation":200,"fireGap":16000,"fireMissileSpeed":400,"position":{"x":514.2620234761716,"y":1600},"orientation":"bottom","status":"stop","cmd":{"id":"6632c3b3-d44e-11e7-b832-efd8446f7f2b","type":"attack","targetType":"hero","targetId":0},"executingCmd":{},"healthPoint":900,"attackCD":440,"fireCD":12480,"dazingRemaining":0,"rebornRemaining":0,"initHealthPoint":900},{"id":9,"type":"hero","camp":"red","name":"shooter","moveSpeed":200,"attackDamageMin":45,"attackDamageMax":55,"attackRange":220,"attackAnimation":120,"attackGap":1300,"attackMissileSpeed":300,"fireName":"damage","fireDamage":300,"fireDuration":0,"fireRange":450,"fireAnimation":200,"fireGap":10000,"fireMissileSpeed":400,"position":{"x":571.2463587355398,"y":1662.4312617781986},"orientation":"left","status":"waitingAttack","cmd":{"id":"6632c3b4-d44e-11e7-b832-efd8446f7f2b","type":"attack","targetType":"hero","targetId":0},"executingCmd":{"id":"65b8d8c4-d44e-11e7-b832-efd8446f7f2b","type":"attack","targetType":"hero","targetId":0},"healthPoint":650,"attackCD":500,"fireCD":3200,"dazingRemaining":0,"rebornRemaining":0,"initHealthPoint":650}]
         */

        private int time;
        private CampsEntity camps;
        private List<TowersEntity> towers;
        private List<HerosEntity> heros;

        public void setTime(int time) {
            this.time = time;
        }

        public void setCamps(CampsEntity camps) {
            this.camps = camps;
        }

        public void setTowers(List<TowersEntity> towers) {
            this.towers = towers;
        }

        public void setHeros(List<HerosEntity> heros) {
            this.heros = heros;
        }

        public int getTime() {
            return time;
        }

        public CampsEntity getCamps() {
            return camps;
        }

        public List<TowersEntity> getTowers() {
            return towers;
        }

        public List<HerosEntity> getHeros() {
            return heros;
        }

        public static class CampsEntity {
            /**
             * blue : {"towerCount":0,"goldCount":0,"killCount":0}
             * red : {"towerCount":6,"goldCount":1118,"killCount":89}
             */

            private StatisticsInfo blue;
            private StatisticsInfo red;

            public void setBlue(StatisticsInfo blue) {
                this.blue = blue;
            }

            public void setRed(StatisticsInfo red) {
                this.red = red;
            }

            public StatisticsInfo getBlue() {
                return blue;
            }

            public StatisticsInfo getRed() {
                return red;
            }
        }

        public static class TowersEntity {
            /**
             * id : 0
             * type : tower
             * position : {"x":2176,"y":1344}
             * goldPerSecond : 2
             * aura : speed
             * camp : red
             * healthPoint : 500
             * initHealthPoint : 500
             */

            private int id;
            private String type;
            private PositionInfo position;
            private int goldPerSecond;
            private String aura;
            private String camp;
            private int healthPoint;
            private int initHealthPoint;

            public void setId(int id) {
                this.id = id;
            }

            public void setType(String type) {
                this.type = type;
            }

            public void setPosition(PositionInfo position) {
                this.position = position;
            }

            public void setGoldPerSecond(int goldPerSecond) {
                this.goldPerSecond = goldPerSecond;
            }

            public void setAura(String aura) {
                this.aura = aura;
            }

            public void setCamp(String camp) {
                this.camp = camp;
            }

            public void setHealthPoint(int healthPoint) {
                this.healthPoint = healthPoint;
            }

            public void setInitHealthPoint(int initHealthPoint) {
                this.initHealthPoint = initHealthPoint;
            }

            public int getId() {
                return id;
            }

            public String getType() {
                return type;
            }

            public PositionInfo getPosition() {
                return position;
            }

            public int getGoldPerSecond() {
                return goldPerSecond;
            }

            public String getAura() {
                return aura;
            }

            public String getCamp() {
                return camp;
            }

            public int getHealthPoint() {
                return healthPoint;
            }

            public int getInitHealthPoint() {
                return initHealthPoint;
            }
        }

        public static class HerosEntity {
            /**
             * id : 0
             * type : hero
             * camp : blue
             * name : shooter
             * moveSpeed : 200
             * attackDamageMin : 45
             * attackDamageMax : 55
             * attackRange : 220
             * attackAnimation : 120
             * attackGap : 1300
             * attackMissileSpeed : 300
             * fireName : damage
             * fireDamage : 300
             * fireDuration : 0
             * fireRange : 450
             * fireAnimation : 200
             * fireGap : 10000
             * fireMissileSpeed : 400
             * position : {"x":464,"y":1648}
             * orientation : bottom
             * status : stop
             * cmd : {}
             * executingCmd : {}
             * healthPoint : 562.6999999999999
             * attackCD : 0
             * fireCD : 0
             * dazingRemaining : 0
             * rebornRemaining : 0
             * initHealthPoint : 650
             */

            private int id;
            private String type;
            private String camp;
            private String name;
            private int moveSpeed;
            private int attackDamageMin;
            private int attackDamageMax;
            private int attackRange;
            private int attackAnimation;
            private int attackGap;
            private int attackMissileSpeed;
            private String fireName;
            private int fireDamage;
            private int fireDuration;
            private int fireRange;
            private int fireAnimation;
            private int fireGap;
            private int fireMissileSpeed;
            private PositionInfo position;
            private String orientation;
            private String status;
            private ExcCmdInfo cmd;
            private ExcCmdInfo executingCmd;
            private double healthPoint;
            private int attackCD;
            private int fireCD;
            private int dazingRemaining;
            private int rebornRemaining;
            private int initHealthPoint;

            public void setId(int id) {
                this.id = id;
            }

            public void setType(String type) {
                this.type = type;
            }

            public void setCamp(String camp) {
                this.camp = camp;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setMoveSpeed(int moveSpeed) {
                this.moveSpeed = moveSpeed;
            }

            public void setAttackDamageMin(int attackDamageMin) {
                this.attackDamageMin = attackDamageMin;
            }

            public void setAttackDamageMax(int attackDamageMax) {
                this.attackDamageMax = attackDamageMax;
            }

            public void setAttackRange(int attackRange) {
                this.attackRange = attackRange;
            }

            public void setAttackAnimation(int attackAnimation) {
                this.attackAnimation = attackAnimation;
            }

            public void setAttackGap(int attackGap) {
                this.attackGap = attackGap;
            }

            public void setAttackMissileSpeed(int attackMissileSpeed) {
                this.attackMissileSpeed = attackMissileSpeed;
            }

            public ExcCmdInfo getCmd() {
                return cmd;
            }

            public void setCmd(ExcCmdInfo cmd) {
                this.cmd = cmd;
            }

            public ExcCmdInfo getExecutingCmd() {
                return executingCmd;
            }

            public void setExecutingCmd(ExcCmdInfo executingCmd) {
                this.executingCmd = executingCmd;
            }

            public void setFireName(String fireName) {
                this.fireName = fireName;
            }

            public void setFireDamage(int fireDamage) {
                this.fireDamage = fireDamage;
            }

            public void setFireDuration(int fireDuration) {
                this.fireDuration = fireDuration;
            }

            public void setFireRange(int fireRange) {
                this.fireRange = fireRange;
            }

            public void setFireAnimation(int fireAnimation) {
                this.fireAnimation = fireAnimation;
            }

            public void setFireGap(int fireGap) {
                this.fireGap = fireGap;
            }

            public void setFireMissileSpeed(int fireMissileSpeed) {
                this.fireMissileSpeed = fireMissileSpeed;
            }

            public void setPosition(PositionInfo position) {
                this.position = position;
            }

            public void setOrientation(String orientation) {
                this.orientation = orientation;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public void setHealthPoint(double healthPoint) {
                this.healthPoint = healthPoint;
            }

            public void setAttackCD(int attackCD) {
                this.attackCD = attackCD;
            }

            public void setFireCD(int fireCD) {
                this.fireCD = fireCD;
            }

            public void setDazingRemaining(int dazingRemaining) {
                this.dazingRemaining = dazingRemaining;
            }

            public void setRebornRemaining(int rebornRemaining) {
                this.rebornRemaining = rebornRemaining;
            }

            public void setInitHealthPoint(int initHealthPoint) {
                this.initHealthPoint = initHealthPoint;
            }

            public int getId() {
                return id;
            }

            public String getType() {
                return type;
            }

            public String getCamp() {
                return camp;
            }

            public String getName() {
                return name;
            }

            public int getMoveSpeed() {
                return moveSpeed;
            }

            public int getAttackDamageMin() {
                return attackDamageMin;
            }

            public int getAttackDamageMax() {
                return attackDamageMax;
            }

            public int getAttackRange() {
                return attackRange;
            }

            public int getAttackAnimation() {
                return attackAnimation;
            }

            public int getAttackGap() {
                return attackGap;
            }

            public int getAttackMissileSpeed() {
                return attackMissileSpeed;
            }

            public String getFireName() {
                return fireName;
            }

            public int getFireDamage() {
                return fireDamage;
            }

            public int getFireDuration() {
                return fireDuration;
            }

            public int getFireRange() {
                return fireRange;
            }

            public int getFireAnimation() {
                return fireAnimation;
            }

            public int getFireGap() {
                return fireGap;
            }

            public int getFireMissileSpeed() {
                return fireMissileSpeed;
            }

            public PositionInfo getPosition() {
                return position;
            }

            public String getOrientation() {
                return orientation;
            }

            public String getStatus() {
                return status;
            }

            public double getHealthPoint() {
                return healthPoint;
            }

            public int getAttackCD() {
                return attackCD;
            }

            public int getFireCD() {
                return fireCD;
            }

            public int getDazingRemaining() {
                return dazingRemaining;
            }

            public int getRebornRemaining() {
                return rebornRemaining;
            }

            public int getInitHealthPoint() {
                return initHealthPoint;
            }
        }
    }
}
