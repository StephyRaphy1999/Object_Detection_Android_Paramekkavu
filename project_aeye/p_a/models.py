from p_a import app
from p_a import db,app
from p_a import db,app,login_manager
from flask_login import UserMixin
from sqlalchemy import ForeignKey
from sqlalchemy.orm import relationship


@login_manager.user_loader
def load_user(id):
    return Register.query.get(int(id))

class Register(db.Model, UserMixin):
    id=db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(80))
    email = db.Column(db.String(80))
    phone = db.Column(db.Integer)
    address = db.Column(db.String(80))
    password = db.Column(db.String(80))
    usertype = db.Column(db.String(80))
    dp_cert = db.Column(db.String(80))
    
class Location(db.Model, UserMixin):
    id=db.Column(db.Integer, primary_key=True)
    time = db.Column(db.String(80))
    location = db.Column(db.String(80))
    u_id = db.Column(db.Integer)
    photo = db.Column(db.String(80))

