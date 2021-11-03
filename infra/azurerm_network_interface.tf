resource "azurerm_network_interface" "vmtf_nic_Team2" {
  name                = "${var.prefix}-Network_interface"
  location            = var.resource_group_location
  resource_group_name =  azurerm_resource_group.Resource-Group-Azure-tf-Team2.name
  ip_configuration {
    name                          = "temaip"
    subnet_id                     = azurerm_subnet.subnet-Team2.id
    private_ip_address_allocation = "Dynamic"
    public_ip_address_id          = azurerm_public_ip.vmtf_pip_Team2.id
  }
}
