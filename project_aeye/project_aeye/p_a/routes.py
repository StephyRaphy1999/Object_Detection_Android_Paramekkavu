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
        # Register
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

        # Admin
        case "reqBlind":
            data = request.get_json()
            users=Register.query.filter_by(usertype='blind',status=0)
            print("____________________blind-data_______________________")
            print(users)
            det=[]
            for i in users:
                dic={}
                dic['id']=i.id
                dic['usertype']=i.usertype
                dic['name']=i.name
                dic['email']=i.email
                dic['phone']=i.phone
                dic['address']=i.address
                det.append(dic)
            return jsonify({'ResponseCode': '201', 'Result': 'true', 'Resultdata':{'blindusers':det}})
        
        case "reqCaretaker":
            data = request.get_json()
            users=Register.query.filter_by(usertype='caretaker',status=0)
            print("____________________caretaker-data_______________________")
            print(users)
            det=[]
            for i in users:
                dic={}
                dic['id']=i.id
                dic['usertype']=i.usertype
                dic['name']=i.name
                dic['email']=i.email
                dic['phone']=i.phone
                dic['address']=i.address
                det.append(dic)
           
            return jsonify({'ResponseCode': '201', 'Result': 'true', 'Resultdata':{'blindusers':det}})
        case "approve":
            data = request.get_json()
            id=data['id']
            row = Register.query.get(id)
            row.status=1
            db.session.commit()
            return jsonify({'ResponseCode': '201', 'Result': 'true', 'ResponseMsg': 'you are approved'})
        case "reject":
            data = request.get_json()
            id=data['id']
            row = Register.query.get(id)
            row.status=2
            db.session.commit()
            return jsonify({'ResponseCode': '201', 'Result': 'true', 'ResponseMsg': 'you are rejected'})
        case "assign":
            data = request.get_json()
            print(data)
            assigned = assign(
                blind_id=data['blind_id'],
                caretaker_id=data['caretaker_id'], 
                )
            db.session.add(assigned)
            db.session.commit()
            return jsonify({'ResponseCode': '201', 'Result': 'true', 'ResponseMsg': 'Blind and Care-taker assigned successfully'})
        case "assignView":
           
            assV=assign.query.all()
            det=[]
            for i in assV:
                dic={}
                dic['id']=i.id
                dic['bid']=i.blind.id
                dic['cid']=i.caretaker.id
                dic['busertype']=i.blind.usertype
                dic['busertype']=i.caretaker.usertype
                dic['bname']=i.blind.name
                dic['cname']=i.caretaker.name
                dic['bemail']=i.blind.email
                dic['cemail']=i.caretaker.email
                dic['bphone']=i.blind.phone
                dic['cphone']=i.caretaker.phone
                dic['baddress']=i.blind.address
                dic['caddress']=i.caretaker.address
                det.append(dic)
            return jsonify({'ResponseCode': '201', 'Result': 'true', 'Resultdata':{'blindusers':det}})
        
            

        case "approvedBlind":
            data = request.get_json()
            users=Register.query.filter_by(usertype='blind',status=1)
            print("_____________________Blind-data_______________________")
            print(users)
            det=[]
            for i in users:
                dic={}
                dic['id']=i.id
                dic['usertype']=i.usertype
                dic['name']=i.name
                dic['email']=i.email
                dic['phone']=i.phone
                dic['address']=i.address
                det.append(dic)
           
            return jsonify({'ResponseCode': '201', 'Result': 'true', 'Resultdata':{'blindusers':det}})
        
        case "approvedCaretaker":
            data = request.get_json()
            users=Register.query.filter_by(usertype='caretaker', status=1)
            print("____________________Caretaker-data_______________________")
            print(users)
            det=[]
            for i in users:
                dic={}
                dic['id']=i.id
                dic['usertype']=i.usertype
                dic['name']=i.name
                dic['email']=i.email
                dic['phone']=i.phone
                dic['address']=i.address
                det.append(dic)
           
            return jsonify({'ResponseCode': '201', 'Result': 'true', 'Resultdata':{'blindusers':det}})
        
        case "rejectedBlind":
            data = request.get_json()
            users=Register.query.filter_by(usertype='blind', status=2)
            print("____________________Blind-data_______________________")
            print(users)
            det=[]
            for i in users:
                dic={}
                dic['id']=i.id
                dic['usertype']=i.usertype
                dic['name']=i.name
                dic['email']=i.email
                dic['phone']=i.phone
                dic['address']=i.address
                det.append(dic)
           
            return jsonify({'ResponseCode': '201', 'Result': 'true', 'Resultdata':{'blindusers':det}})
        
        case "rejectedCaretaker":
            data = request.get_json()
            users=Register.query.filter_by(usertype='caretaker', status=2)
            print("____________________Caretaker-data_______________________")
            print(users)
            det=[]
            for i in users:
                dic={}
                dic['id']=i.id
                dic['usertype']=i.usertype
                dic['name']=i.name
                dic['email']=i.email
                dic['phone']=i.phone
                dic['address']=i.address
                det.append(dic)
           
            return jsonify({'ResponseCode': '201', 'Result': 'true', 'Resultdata':{'blindusers':det}})
        





