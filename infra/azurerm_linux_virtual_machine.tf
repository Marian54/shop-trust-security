resource "tls_private_key" "example_ssh" {
  algorithm = "RSA"
  rsa_bits = 4096
}

resource "azurerm_linux_virtual_machine" "VirtualMachine_Terraform_Team_2" {
  name                = "${var.hostname}-site"
  resource_group_name =  azurerm_resource_group.Resource-Group-Azure-tf-Team2.name
  location            = var.resource_group_location
  size             = var.vm_size
  network_interface_ids         = [azurerm_network_interface.vmtf_nic_Team2.id]


  admin_ssh_key {
    username   = var.admin_username
    public_key = tls_private_key.example_ssh.public_key_openssh
  }

  /*
    admin_ssh_key {
      username   = var.admin_username
      public_key = file("${path.module}/id_rsa3.pub")
    }
  */

  source_image_reference  {
    publisher = "Canonical"
    offer     = "UbuntuServer"
    sku       = "16.04-LTS"
    version   = "latest"
  }

  os_disk {
    caching              = "ReadWrite"
    storage_account_type = "Standard_LRS"
    name = "tfstate4711"
  }

/*
  provisioner "remote-exec" {
    inline = [
      "sudo apt -y install apache2"
    ]

    connection {
      host = azurerm_public_ip.vmtf_pip.fqdn
      user = "azureuser"
      type = "ssh"
      private_key = file("${path.module}/id_rsa3")
      agent = false
    }
  }*/

  admin_username = "azureuser"
}
