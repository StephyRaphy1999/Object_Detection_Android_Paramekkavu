from flask import Flask, render_template, request, redirect, flash, abort, url_for
from p_a import app, db
from p_a import app
from p_a.models import *
from flask import Flask, request, jsonify, make_response
import json
import base64


@app.route('/object_detection', methods=['GET', 'POST'])
def object_detection():
    
    apiCall = request.args.get('apicall')
   
    
    # if apiCall == "ureg":
    match apiCall:
        case "blind":
            data = request.get_json()
            print(data)
            new_user = Register(
                email=data['email'],
                name=data['name'], 
                password=data['password'], 
                phone=data['phone'],
                address=data['address'], 
                dp_cert=data['dp_cert'],
                usertype="blind"
                )
            db.session.add(new_user)
            db.session.commit()
            return jsonify({'ResponseCode': '201', 'Result': 'true', 'ResponseMsg': 'Blind Registered Successfully!'})
        case "caretaker":
            data = request.get_json()
            print(data)
            new_user = Register(
                email=data['email'],
                name=data['name'], 
                password=data['password'], 
                phone=data['phone'],
                address=data['address'], 
                dp_cert=data['dp_cert'],
                usertype="caretaker"
                )
            db.session.add(new_user)
            db.session.commit()
            return jsonify({'ResponseCode': '201', 'Result': 'true', 'ResponseMsg': 'Care-taker Registered Successfully!'})
        case "signin":
            data = request.get_json()
            print(data)
            email=data['email']
            password=data['password']
            a = Register.query.filter_by(email=email,password=password,usertype="admin").first()
            b = Register.query.filter_by(email=email,password=password,usertype="blind").first()
            c = Register.query.filter_by(email=email,password=password,usertype="caretaker").first()
            if a:
                return jsonify({'ResponseCode': '201', 'Result': 'true', 'ResponseMsg': 'Admin'})
            elif b:
                return jsonify({'ResponseCode': '201', 'Result': 'true', 'ResponseMsg': 'Blind'})
            else:
                return jsonify({'ResponseCode': '201', 'Result': 'true', 'ResponseMsg': 'Care-taker'})





